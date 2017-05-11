package com.hezhi.kiss;

import com.hezhi.kiss.http.okhttp.HttpClient;
import com.hezhi.kiss.http.okhttp.request.CommonRequest;
import com.hezhi.kiss.http.okhttp.request.RequestParam;
import com.hezhi.kiss.http.okhttp.response.DisposeDataHandle;
import com.hezhi.kiss.http.okhttp.response.DisposeDataListener;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void testLogin() throws Exception {
        RequestParam params = new RequestParam();
        params.put("mb", "1");
        params.put("pwd", "1");
        HttpClient.get(CommonRequest.createGetRequest("ds","http://yuexibo.top/yxbApp/user_info.json",params),
                new DisposeDataHandle(new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        System.out.println("responseObj = [" + responseObj + "]");
                    }

                    @Override
                    public void onFail(Object reasonObj) {

                    }
                }, null));
    }
 }