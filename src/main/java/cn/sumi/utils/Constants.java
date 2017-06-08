package cn.sumi.utils;

/**
 * 博客配置常量
 * Created by gonghf95 on 6/5/17.
 */
public class Constants {
    public static String BLOG = "Sumi";//o

    public static String ACTION_DEL = "del";
    public static String ACTION_DEEP_DELETE = "deepdel";

    /**
     *
     * */
    public static int STATUS_SUCCESS = 1;
    public static int STATUS_FAILURE = 0;

    /**
     * 文章在回收站还是在草稿箱
     */
    public static int ARTICLE_TYPE_NORMAL = 0;
    public static int ARTICLE_TYPE_DRAFT = 1;
    public static int ARTICLE_TYPE_DELETED = 2;

    /**
     * 请求类型
     */
    public static String REQUEST_TYPE_NORMAL = "normal";
    public static String REQUEST_TYPE_DRAFT = "draft";
    public static String REQUEST_TYPE_DELETED = "deleted";
}
