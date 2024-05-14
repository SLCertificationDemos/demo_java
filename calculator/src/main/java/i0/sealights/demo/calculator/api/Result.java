package i0.sealights.demo.calculator.api;

public class Result {
    private Number result;
    private String headers;
    private String cookies;

    public Result(Number result) {
        this.result = result;
    }

    public Number getResult() {
        return result;
    }

    public String getHeaders() {
        return headers;
    }

    public String getCookies() {
        return cookies;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }
}
