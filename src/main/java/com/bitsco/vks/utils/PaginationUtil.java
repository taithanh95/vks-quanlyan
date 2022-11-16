package com.bitsco.vks.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

import com.bitsco.vks.exception.ApplicationException;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Utility class for handling pagination.
 *
 * <p>
 * Pagination uses the same principles as the <a href="https://developer.github.com/v3/#pagination">GitHub API</a>,
 * and follow <a href="http://tools.ietf.org/html/rfc5988">RFC 5988 (Link header)</a>.
 */
public final class PaginationUtil {

    private PaginationUtil() {
    }

    public static HttpHeaders generatePaginationHttpHeaders(Page page, String baseUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    private static String generateUri(String baseUrl, int page, int size) {
        return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", page).queryParam("size", size).toUriString();
    }

    public static HttpHeaders generateSearchPaginationHttpHeaders(String query, Page page, String baseUrl) {
        String escapedQuery;
        try {
            escapedQuery = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    public static HttpHeaders generateSearchPaginationHttpHeaders(Object searchDto, Page page, String baseUrl) throws ApplicationException {

        Field[] fields = searchDto.getClass().getDeclaredFields();
        String escapedQuery = "";
        for (Field field : fields) {
            field.setAccessible(true);
            //if(field.getDeclaringClass(). instanceof Integer){
            Object data;
            try {
                data = field.get(searchDto);
                if (data == null) {
                    escapedQuery += ("&" + field.getName() + "=");
                } else {
                    escapedQuery += ("&" + field.getName() + "=" + URLEncoder.encode(data.toString(), "UTF-8"));
                }
            } catch (IllegalArgumentException | IllegalAccessException | UnsupportedEncodingException e) {
                throw new ApplicationException(e.getMessage(), e);
            }

            //}


        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + escapedQuery + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + escapedQuery + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + escapedQuery + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + escapedQuery + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    public static HttpHeaders generateSearchPaginationHttpHeaders(Object searchDto, Pageable page, String baseUrl, Long totalRecords) throws ApplicationException {
        int totalPages;
        if (totalRecords % page.getPageSize() == 0) {
            totalPages = (int) (totalRecords / page.getPageSize());
        } else {
            totalPages = (int) ((totalRecords / page.getPageSize()) + 1);
        }

        Field[] fields = searchDto.getClass().getDeclaredFields();
        String escapedQuery = "";
        for (Field field : fields) {
            field.setAccessible(true);
            //if(field.getDeclaringClass(). instanceof Integer){
            Object data;
            try {
                data = field.get(searchDto);
                if (data == null) {
                    escapedQuery += ("&" + field.getName() + "=");
                } else {
                    escapedQuery += ("&" + field.getName() + "=" + URLEncoder.encode(data.toString(), "UTF-8"));
                }
            } catch (IllegalArgumentException | IllegalAccessException | UnsupportedEncodingException e) {
                throw new ApplicationException(e.getMessage(), e);
            }

            //}


        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(totalRecords));
        String link = "";
        if ((page.getPageNumber() + 1) < totalPages) {
            link = "<" + generateUri(baseUrl, page.getPageNumber() + 1, page.getPageSize()) + escapedQuery + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getPageNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getPageNumber() - 1, page.getPageSize()) + escapedQuery + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (totalPages > 0) {
            lastPage = totalPages - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getPageSize()) + escapedQuery + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getPageSize()) + escapedQuery + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }
}

