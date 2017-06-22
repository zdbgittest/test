package mytest.myzj;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月21日 下午3:46:53
 */
public class Result {
    private String errorCode;
    private String errorMsg;

    //是否正确
    public boolean isSuccess() {
        if (this.errorCode == null && this.errorMsg == null) {
            return true;
        }
        return false;
    }

    public void setError(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
