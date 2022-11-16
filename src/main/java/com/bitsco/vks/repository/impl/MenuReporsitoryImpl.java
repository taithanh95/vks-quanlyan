package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.AdmFunctionsResponseDTO;
import com.bitsco.vks.dto.AdmGroupsResponseDTO;
import com.bitsco.vks.entity.AdmFunctions;
import com.bitsco.vks.repository.MenuReporsitory;
import com.bitsco.vks.utils.StringCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MenuReporsitoryImpl implements MenuReporsitory {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<AdmFunctionsResponseDTO> getFunctionsTreeForGroup(String module, String groupid) {
        RowMapper<AdmFunctionsResponseDTO> rm = new SingleColumnRowMapper<AdmFunctionsResponseDTO>() {
            @Override
            public AdmFunctionsResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdmFunctionsResponseDTO admFunctionsResponseDTO = new AdmFunctionsResponseDTO();
                admFunctionsResponseDTO.setFuncid(rs.getString("funcid"));
                admFunctionsResponseDTO.setFuncname(rs.getString("funcname"));
                admFunctionsResponseDTO.setParentid(rs.getString("parentid"));
                admFunctionsResponseDTO.setGroupid(rs.getString("groupid"));
                return admFunctionsResponseDTO;
            }
        };
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_MENU)
                .withFunctionName(Constant.FUNCTION.FN_GET_TREE_FOR_GROUP)
                .returningResultSet("return", rm);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_groupid", groupid)
                .addValue("p_module", module);
        return jdbcCall.executeFunction((Class<List<AdmFunctionsResponseDTO>>) (Class) List.class, param);
    }

    @Override
    public List<AdmFunctionsResponseDTO> getFunctionsTreeForUser(String userid, String module) {
        RowMapper<AdmFunctionsResponseDTO> rm = new SingleColumnRowMapper<AdmFunctionsResponseDTO>() {
            @Override
            public AdmFunctionsResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdmFunctionsResponseDTO admFunctionsResponseDTO = new AdmFunctionsResponseDTO();
                admFunctionsResponseDTO.setFuncid(rs.getString("funcid"));
                admFunctionsResponseDTO.setFuncname(rs.getString("funcname"));
                admFunctionsResponseDTO.setParentid(rs.getString("parentid"));
                admFunctionsResponseDTO.setUserid(rs.getString("userid"));
                return admFunctionsResponseDTO;
            }
        };
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_MENU)
                .withFunctionName(Constant.FUNCTION.FN_GET_TREE_FOR_USER)
                .returningResultSet("return", rm);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_userid", userid)
                .addValue("p_module", module);
        return jdbcCall.executeFunction((Class<List<AdmFunctionsResponseDTO>>) (Class) List.class, param);
    }

    @Override
    public String grantFunctionsToGroup(String groupid, String module, List<AdmFunctions> lstNodes, String username) {
        String revoke = revokeFnGroup(groupid,module);
        if (!StringCommon.isNullOrBlank(revoke)) return revoke;
        try {
            SimpleJdbcCall jdbcCall;
            for (AdmFunctions node : lstNodes) {
                jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(Constant.PACKAGE.PKG_MENU)
                        .withFunctionName(Constant.FUNCTION.FN_GRANT_FUNC_TO_GROUP)
                        .withReturnValue();

                SqlParameterSource param = new MapSqlParameterSource()
                        .addValue("p_groupid", groupid)
                        .addValue("p_funcid", node.getFuncid())
                        .addValue("p_crtuser", username);
                String _return = (String) jdbcCall.execute(param).get("return");
                // Có lỗi? Rollback và thoát khỏi vòng lặp
                if (_return != null) {
                    return _return;
                }
            }
        }catch (Exception e) {
            throw(e);
        }
        return null;
    }

    @Override
    public String grantFunctionsToUser(String userid, String module, List<AdmFunctions> lstNodes, String username) {
        String revoke = revokeFnUser(userid,module);
        if (!StringCommon.isNullOrBlank(revoke)) return revoke;
        try {
            SimpleJdbcCall jdbcCall;
            for (AdmFunctions node : lstNodes) {
                jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(Constant.PACKAGE.PKG_MENU)
                        .withFunctionName(Constant.FUNCTION.FN_GRANT_FUNC_TO_USER)
                        .withReturnValue();

                SqlParameterSource param = new MapSqlParameterSource()
                        .addValue("p_userid", userid)
                        .addValue("p_funcid", node.getFuncid())
                        .addValue("p_crtuser", username);
                String _return = (String) jdbcCall.execute(param).get("return");
                // Có lỗi? Rollback và thoát khỏi vòng lặp
                if (_return != null) {
                    return _return;
                }
            }
        }catch (Exception e) {
            throw(e);
        }
        return null;
    }

    @Override
    public String grantGroupsToUser(String userid, List<String> lstGroups, String username) {
        String revoke = revokeGroupsUser(userid);
        if (!StringCommon.isNullOrBlank(revoke)) return revoke;
        try {
            SimpleJdbcCall jdbcCall;
            for (String group : lstGroups) {
                jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(Constant.PACKAGE.PKG_MENU)
                        .withFunctionName(Constant.FUNCTION.FN_GRANT_GROUP_TO_USER)
                        .withReturnValue();

                SqlParameterSource param = new MapSqlParameterSource()
                        .addValue("p_userid", userid)
                        .addValue("p_groupid", StringCommon.isNullOrBlank(group) ? null : group.split("-")[0].trim())
                        .addValue("p_crtuser", username);
                String _return = (String) jdbcCall.execute(param).get("return");
                // Có lỗi? Rollback và thoát khỏi vòng lặp
                if (_return != null) {
                    return _return;
                }
            }
        }catch (Exception e) {
            throw(e);
        }
        return null;
    }

    // lstGroup
    @Override
    public List<AdmFunctionsResponseDTO> getLstGroupSpp(String scppid, String sppid) {
        try {
            RowMapper<AdmFunctionsResponseDTO> rm = new SingleColumnRowMapper<AdmFunctionsResponseDTO>() {
                @Override
                public AdmFunctionsResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                    AdmFunctionsResponseDTO admFunctionsResponseDTO = new AdmFunctionsResponseDTO();
                    admFunctionsResponseDTO.setGroupid(rs.getString("groupid"));
                    admFunctionsResponseDTO.setGroupname(rs.getString("groupname"));
                    return admFunctionsResponseDTO;
                }
            };
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MENU)
                    .withFunctionName(Constant.FUNCTION.FN_GET_GROUPS_OF_SPP)
                    .returningResultSet("return", rm);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_csppid", scppid)
                    .addValue("p_sppid", sppid);
            return jdbcCall.executeFunction((Class<List<AdmFunctionsResponseDTO>>) (Class) List.class, param);
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public List<AdmGroupsResponseDTO> getGroups(String userid, String sppid) {
        try {
            RowMapper<AdmGroupsResponseDTO> rm = new SingleColumnRowMapper<AdmGroupsResponseDTO>() {
                @Override
                public AdmGroupsResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                    AdmGroupsResponseDTO res = new AdmGroupsResponseDTO();
                    res.setGroupid(rs.getString("groupid"));
                    res.setGroupname(rs.getString("groupname"));
                    res.setUserid(rs.getString("userid"));
                    return res;
                }
            };
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MENU)
                    .withFunctionName(Constant.FUNCTION.FN_GET_GROUPS_OF_USER)
                    .returningResultSet("return", rm);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_userid", userid)
                    .addValue("p_sppid", sppid);
            return jdbcCall.executeFunction((Class<List<AdmGroupsResponseDTO>>) (Class) List.class, param);
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public List<AdmFunctionsResponseDTO> getMenuByModule(String username, String module) {
        RowMapper<AdmFunctionsResponseDTO> rm = new SingleColumnRowMapper<AdmFunctionsResponseDTO>() {
            @Override
            public AdmFunctionsResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdmFunctionsResponseDTO admFunctionsResponseDTO = new AdmFunctionsResponseDTO();
                admFunctionsResponseDTO.setFuncid(rs.getString("funcid"));
                admFunctionsResponseDTO.setFuncname(rs.getString("funcname"));
                admFunctionsResponseDTO.setParentid(rs.getString("parentid"));
                admFunctionsResponseDTO.setMenuorder(rs.getString("menuorder"));
                admFunctionsResponseDTO.setPath(rs.getString("path"));
                admFunctionsResponseDTO.setSubmenu(rs.getString("submenu"));
                return admFunctionsResponseDTO;
            }
        };
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_MENU)
                .withFunctionName(Constant.FUNCTION.FN_GET_MENU_BY_MODULE)
                .returningResultSet("return", rm);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_userid", username)
                .addValue("p_module", StringCommon.isNullOrBlank(module) ? null : module);

        return jdbcCall.executeFunction((Class<List<AdmFunctionsResponseDTO>>) (Class) List.class, param);
    }

    private String revokeFnGroup(String groupid, String module) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_MENU)
                .withFunctionName(Constant.FUNCTION.FN_REVOKE_FUNCS_OF_GROUP)
                .withReturnValue();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_groupid", groupid)
                .addValue("p_module", module);
        String _return = (String) jdbcCall.execute(param).get("return");
        return _return;
    }

    private String revokeFnUser(String userid, String module) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_MENU)
                .withFunctionName(Constant.FUNCTION.FN_REVOKE_FUNCS_OF_USER)
                .withReturnValue();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_userid", userid)
                .addValue("p_module", module);
        String _return = (String) jdbcCall.execute(param).get("return");
        return _return;
    }

    private String revokeGroupsUser(String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_MENU)
                .withFunctionName(Constant.FUNCTION.FN_REVOKE_GROUPS_OF_USER)
                .withReturnValue();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_userid", userid);
        String _return = (String) jdbcCall.execute(param).get("return");
        return _return;
    }
}
