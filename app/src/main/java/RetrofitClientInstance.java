import retrofit2.Retrofit;

public class RetrofitClientInstance {

    private  static Retrofit retrofit;
    private static final String BASE_URL="https://mantis.mobilebox.pl";

    public static Retrofit getRetrofitInstance()
    {
        if(retrofit==null) {
        retrofit=new retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
      //  .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
        }


}


