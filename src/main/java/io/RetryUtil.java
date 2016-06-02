package io;

/**
 * Created by tushar.mandar on 6/2/16.
 */
public class RetryUtil {
    public static <ReturnType> ReturnType retry(int maxRetry,
                                                RetryFunctionHandler<ReturnType> function) throws Exception{
        int retry = 0;
        boolean completed = false;
        ReturnType returnValue = null;
        while(!completed){
            try {
                returnValue = function.run();
                completed = true;
            } catch (Exception e) {
                if(retry > maxRetry){
                    throw e;
                }
                retry++;
            }
        }
        return returnValue;
    }
}
