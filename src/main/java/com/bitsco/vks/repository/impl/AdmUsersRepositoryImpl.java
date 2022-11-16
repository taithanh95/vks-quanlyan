package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.ChangePasswordDTO;
import com.bitsco.vks.dto.UserSaveDTO;
import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.repository.AdmUsersRepository;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.utils.StringCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdmUsersRepositoryImpl implements AdmUsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static MessageDigest md;
    private static String algorithm = "MD5";
    private static String provider = "SUN";
    private static String charset = "UTF-8";
    private static String presalt = "<PWD>";
    private static String sufsalt = "</PWD>";

    @Override
    public List<AdmUsers> getUserLogin(String p_userid, String p_password) {

        RowMapper<AdmUsers> rm = new SingleColumnRowMapper<AdmUsers>() {
            @Override
            public AdmUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdmUsers users = new AdmUsers();
                users.setUserid(rs.getString("USERID"));
                //users.setPassword(rs.getString("PASSWORD"));
                //users.setExpiredate(rs.getDate("EXPIREDATE"));
                users.setSppid(rs.getString("SPPID"));
                //users.setCrtuser(rs.getString("CRTUSER"));
                //users.setCrtDate(rs.getDate("CRTDATE"));
                //users.setMdfuser(rs.getString("MDFUSER"));
                //users.setMdfdate(rs.getDate("MDFDATE"));
                users.setInspcode(rs.getString("INSPCODE"));
                users.setLocked(rs.getBoolean("LOCKED"));
                //users.setDepartid(rs.getString("DEPARTID"));
                boolean isDepart = rs.getString("isdepart").equals("Y");
                users.setIsdepart(isDepart);
                users.setFullname(rs.getString("FULLNAME"));
                return users;
            }
        };

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_ADM_USERS") //package name
                .withFunctionName("fn_get_user_login")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_userid", p_userid)
                .addValue("p_password", p_password);
        //First parameter is function output parameter type.

        return jdbcCall.executeFunction((Class<List<AdmUsers>>) (Class) List.class, paramMap);
    }

    @Override
    public List<AdmUsers> getUserInfo(String p_userid) {
        RowMapper<AdmUsers> rm = new SingleColumnRowMapper<AdmUsers>() {
            @Override
            public AdmUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdmUsers users = new AdmUsers();
                users.setUserid(rs.getString("USERID"));
                //users.setPassword(rs.getString("PASSWORD"));
                //users.setExpiredate(rs.getDate("EXPIREDATE"));
                users.setSppid(rs.getString("SPPID"));
                //users.setCrtuser(rs.getString("CRTUSER"));
                //users.setCrtDate(rs.getDate("CRTDATE"));
                //users.setMdfuser(rs.getString("MDFUSER"));
                //users.setMdfdate(rs.getDate("MDFDATE"));
                users.setInspcode(rs.getString("INSPCODE"));
                users.setLocked(rs.getBoolean("LOCKED"));
                //users.setDepartid(rs.getString("DEPARTID"));
                boolean isDepart = rs.getString("isdepart").equals("Y");
                users.setIsdepart(isDepart);
                users.setFullname(rs.getString("FULLNAME"));
                return users;
            }
        };

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_ADM_USERS") //package name
                .withFunctionName("fn_get_user_info")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_userid", p_userid);
        //First parameter is function output parameter type.

        return jdbcCall.executeFunction((Class<List<AdmUsers>>) (Class) List.class, paramMap);
    }

    @Override
    public AdmUsers findByUsername(String username) {

        AdmUsers users = this.jdbcTemplate.queryForObject(
                "SELECT * FROM Adm_users where userid = ?",
                new Object[]{username},
                new RowMapper<AdmUsers>() {
                    public AdmUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
                        AdmUsers users = new AdmUsers();
                        users.setUserid(rs.getString("USERID"));
                        users.setPassword(rs.getString("PASSWORD"));
                        users.setSppid(rs.getString("SPPID"));
                        users.setCrtuser(rs.getString("CRTUSER"));
                        users.setMdfuser(rs.getString("MDFUSER"));
                        users.setInspcode(rs.getString("INSPCODE"));
                        users.setLocked(rs.getBoolean("LOCKED"));
                        users.setDepartid(rs.getString("DEPARTID"));
                        users.setUserid(rs.getString("USERID"));

                        users.setExpiredate(rs.getDate("EXPIREDATE"));
                        users.setCrtDate(rs.getDate("CRTDATE"));
                        users.setMdfdate(rs.getDate("MDFDATE"));
                        return users;
                    }
                });

        return users;
    }


    //lstInspectors
    @Override
    public List<LstInspector> getLstInspectors(String sppid) {
        try {
            RowMapper<LstInspector> rm = new SingleColumnRowMapper<LstInspector>() {
                @Override
                public LstInspector mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LstInspector inspector = new LstInspector();
                    inspector.setInspcode(rs.getString("INSPCODE"));
                    inspector.setSppid(rs.getString("SPPID"));
                    inspector.setFullname(rs.getString("FULLNAME"));
                    inspector.setAddress(rs.getString("ADDRESS"));
                    inspector.setTel(rs.getString("TEL"));
                    inspector.setJobtitle(rs.getString("JOBTITLE"));
                    inspector.setStatus(rs.getString("STATUS"));
                    inspector.setPosition(rs.getString("POSITION"));
                    return inspector;
                }
            };

            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_USERS)
                    .withFunctionName(Constant.FUNCTION.FN_GET_LST_INSPECTORS)
                    .returningResultSet("return", rm);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_sppid", sppid);
            return jdbcCall.executeFunction((Class<List<LstInspector>>) (Class) List.class, param);
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public String insOrUpd(UserSaveDTO req, String username) {
        try {
            String password = "";
            if ("I".equals(req.getAction())) {
                try {
                    password = encode(decodeBase64(req.getUser().getPassword()));
                } catch (Exception e) {
                    throw new CommonException(Response.DATA_INVALID, "Không thể giải mã mật khẩu");
                }
            } else if (!StringCommon.isNullOrBlank(req.getUser().getPassword()) && "U".equals(req.getAction())) {
                try {
                    password = encode(decodeBase64(req.getUser().getPassword()));
                } catch (Exception e) {
                    throw new CommonException(Response.DATA_INVALID, "Không thể giải mã mật khẩu");
                }
            }
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_USERS)
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_action", req.getAction())
                    .addValue("p_userid", req.getUser() != null ? req.getUser().getUsername() : null)
                    .addValue("p_password", password)
                    .addValue("p_sppid", req.getSppid())
                    .addValue("p_inspcode", req.getInspcode())
                    .addValue("p_expiredate", req.getExpiredate())
                    .addValue("p_locked", req.isLocked() ? "Y" : null)
                    .addValue("p_delothers", null)
                    .addValue("p_crtuser", username)
                    .addValue("p_departid", req.getDepartid())
                    .addValue("p_groupid", req.getGroupid());

//            sp_log(req.getAction(), req, username);
            return (String) jdbcCall.execute(param).get("return");
        } catch (CommonException e) {
            throw (e);
        }
    }

    @Override
    public String delete(UserSaveDTO req, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_USERS)
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_userid", req.getUser() != null ? req.getUser().getUsername() : null);

            return (String) jdbcCall.execute(param).get("return");
        } catch (CommonException e) {
            throw (e);
        }
    }

    private String encode(String stPassword_) {
        try {
            md = MessageDigest.getInstance(algorithm, provider);

            if (md != null) {
                md.reset();
                return processPassword(stPassword_);
            }
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static String processPassword(String stPassword_) throws IOException, UnsupportedEncodingException {
        String s = presalt + stPassword_ + sufsalt;
        md.update(s.getBytes(charset));
        byte[] byteData = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private static String decodeBase64(String encode) throws IOException {
        return new String(new BASE64Decoder().decodeBuffer(encode));
    }


    @Override
    public String changePassword(ChangePasswordDTO req) {
        String oldPass = "";
        String newPass = "";
        try {
            oldPass = encode(decodeBase64(req.getPasswordOld()));
            newPass = encode(decodeBase64(req.getPasswordNew()));
        } catch (Exception e) {
            throw new CommonException(Response.DATA_INVALID, "Không thể giải mã mật khẩu");
        }
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_USERS)
                    .withFunctionName(Constant.FUNCTION.FN_CHANGEPWD);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_userid", req.getUserid())
                    .addValue("p_password", oldPass)
                    .addValue("p_newpassword", newPass);

            return (String) jdbcCall.execute(param).get("return");
        } catch (CommonException e) {
            throw (e);
        }
    }
}
