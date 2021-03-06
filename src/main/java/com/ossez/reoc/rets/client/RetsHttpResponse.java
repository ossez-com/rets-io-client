package com.ossez.reoc.rets.client;

import java.io.InputStream;
import java.util.Map;

/**
 * Interface for retrieving useful header fields from a RETS HTTP response
 *
 * @author YuCheng Hu
 */
public interface RetsHttpResponse {
    public int getResponseCode() throws RetsException;

    public Map getHeaders() throws RetsException;

    public String getHeader(String hdr) throws RetsException;

    public String getCookie(String cookie) throws RetsException;

    public String getCharset() throws RetsException;

    public InputStream getInputStream() throws RetsException;

    public Map getCookies() throws RetsException;

}
