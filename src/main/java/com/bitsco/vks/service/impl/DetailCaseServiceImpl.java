package com.bitsco.vks.service.impl;

import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.jasper.JasperPrintService;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.service.DetailCaseService;
import com.bitsco.vks.utils.DateCommon;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/04/2022
 * Time: 10:02 AM
 */
@Service
@Transactional
public class DetailCaseServiceImpl implements DetailCaseService {

    Connection conn;

    @Autowired
    private JasperPrintService jasperPrintService;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String pass;

    @Override
    public byte[] requestReportPdf(String casecode, String regicode) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url,user,pass);
        JasperPrint jp = null;
        String date = DateCommon.convertDateToStringByPattern(new Date(), "dd/MM/yyyy");
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("CASECODE", casecode);
            parameters.put("REGICODE", regicode);
            parameters.put("date", date);
            File file = ResourceUtils.getFile("classpath:jasper/caseInfo.jrxml");
            InputStream input = new FileInputStream(file);
            JasperDesign jasperDesign = JRXmlLoader.load(input);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jp = JasperFillManager.fillReport(jasperReport, parameters, conn);
            return jasperPrintService.exportReportPdf(jp);
        } catch (CommonException e) {
            throw e;
        } catch (FileNotFoundException e) {
            throw new CommonException(Response.SYSTEM_ERROR, "FileNotFoundException khi requestReportPdf thực hiện tạo JasperPrint. Chi tiết: " + e.getMessage());
        } catch (JRException e) {
            throw new CommonException(Response.SYSTEM_ERROR, "JRException khi requestReportPdf thực hiện tạo JasperPrint. Chi tiết: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}
