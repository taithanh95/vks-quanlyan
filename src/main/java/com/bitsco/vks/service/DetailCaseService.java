package com.bitsco.vks.service;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/04/2022
 * Time: 10:00 AM
 */
public interface DetailCaseService {
    byte[] requestReportPdf(String casecode, String regicode) throws Exception;
}
