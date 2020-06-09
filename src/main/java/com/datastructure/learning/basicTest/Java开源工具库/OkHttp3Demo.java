package com.datastructure.learning.basicTest.Java开源工具库;

/**
 * @author: lipan
 * @date: 2020/6/9
 * @description: 官方地址：https://square.github.io/okhttp/ 一个 HTTP 客户端，使用简单，性能良好，是时候放弃 HttpClient 了。
 */
public class OkHttp3Demo {

  /**
   * 一个 get 请求：
   *
   * OkHttpClient client = new OkHttpClient();
   *
   * String run(String url) throws IOException { Request request = new Request.Builder()
   * .url(url) .build();
   *
   * try (Response response = client.newCall(request).execute()) { return
   * response.body().string(); } }
   *
   *
   * 一个 post 请求：
   *
   * public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
   *
   * OkHttpClient client = new OkHttpClient();
   *
   * String post(String url, String json) throws IOException { RequestBody body =
   * RequestBody.create(json, JSON); Request request = new Request.Builder() .url(url) .post(body)
   * .build(); try (Response response = client.newCall(request).execute()) { return
   * response.body().string(); } }
   */
}
