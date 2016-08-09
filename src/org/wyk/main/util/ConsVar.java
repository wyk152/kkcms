package org.wyk.main.util;

public class ConsVar {
    /** 用户session会话名称 */
    public static final String Session_Name = PropertiesUtil.getStringProperty("session_name", "userPassport");

//    上传文件保存目录
    public static final String uploadDir = PropertiesUtil.getStringProperty("uploadDir", "");

//    上传文件临时保存目录
    public static final String uploadTmpDir = PropertiesUtil.getStringProperty("uploadTmpDir", "");

//    限制的图片上传类型
    public static final String permitUpImg = PropertiesUtil.getStringProperty("permitUpImg", "");

//    水印图片路径
    public static final String waterImg = PropertiesUtil.getStringProperty("waterImg", "");

//    限制上传文件大小
    public static final int permitFileSize = Integer.valueOf(PropertiesUtil.getStringProperty("permitFileSize",
            "1024000"));

//    缩略图的宽度
    public static final int s_pro_img_width = Integer.valueOf(PropertiesUtil
            .getStringProperty("s_pro_img_width", "100"));

//    水印图片的位置
    public static final int watermark_pos = Integer.valueOf(PropertiesUtil.getStringProperty("watermark_pos", "1"));

//    模板文件路径
    public static final String ftlPath = PropertiesUtil.getStringProperty("ftlPath", "");

    
   //邮件模板路径
    public static final String email_path=PropertiesUtil.getStringProperty("email_path", "");
    
//    商品静态化文件保存路径
    public static final String spFilePath = PropertiesUtil.getStringProperty("spFilePath", "");

    public static final String product_img_url = PropertiesUtil.getStringProperty("product_img_url", "");
    
    public static final String upload_url = PropertiesUtil.getStringProperty("upload_url", "");
    
    public static final String upload_product_img_url = PropertiesUtil.getStringProperty("upload_product_img_url", "");
    
    public static final String upload_swf_url = PropertiesUtil.getStringProperty("upload_swf_url", "");
    
    public static final String upload_product_append_img_url = PropertiesUtil.getStringProperty("upload_product_append_img_url", "");
    
    public static final String host_domain = PropertiesUtil.getStringProperty("host_domain", "");
    
    /***药品分类固定ID号****/
    public static final String yaoping_cid=PropertiesUtil.getStringProperty("yaoping_cid", "");
    
    public static final String baojian_cid=PropertiesUtil.getStringProperty("baojian_cid", "");
    
    public static final String yaoshan_cid=PropertiesUtil.getStringProperty("yaoshan_cid", "");
    
    public static final String muying_cid=PropertiesUtil.getStringProperty("muying_cid", "");
    
    public static final String meirong_cid=PropertiesUtil.getStringProperty("meirong_cid", "");
    
    public static final String qixie_cid=PropertiesUtil.getStringProperty("qixie_cid", "");
    
    public static final String chengren_cid=PropertiesUtil.getStringProperty("chengren_cid", "");
    
    public static final String shop_url = PropertiesUtil.getStringProperty("shop_url", "");
    
    public static final String resource_url = PropertiesUtil.getStringProperty("resource_url", "");
    public static final String b2b_webContent_url = PropertiesUtil.getStringProperty("b2b_webContent_url", "");
    
    public static final String pingtai_url=PropertiesUtil.getStringProperty("pingtai_url", "");
    public static final String pingtai_web=PropertiesUtil.getStringProperty("pingtai_web", "");
    public static final String pingtai_base=PropertiesUtil.getStringProperty("pingtai_base", "");
    
    
    public static final String domain_www_b2c=PropertiesUtil.getStringProperty("domain_www_b2c", "");
    public static final String platSearch_url=PropertiesUtil.getStringProperty("platSearch_url", "");
    public static final String cbSearch=PropertiesUtil.getStringProperty("cbSearch", "");
    public static final String shopSearch_url=PropertiesUtil.getStringProperty("shopSearch_url", "");
    public static final String domain_www=PropertiesUtil.getStringProperty("domain_www", "");
    public static final String domain_shop=PropertiesUtil.getStringProperty("domain_shop", "");
    public static final String domain_shop_shop=PropertiesUtil.getStringProperty("domain_shop_shop", "");
    public static final String domain_www_shop=PropertiesUtil.getStringProperty("domain_www_shop", "");
    public static final String domain_www_shop_member=PropertiesUtil.getStringProperty("domain_www_shop_member", "");
    public static final String domain_img_images=PropertiesUtil.getStringProperty("domain_img_images", "");
    public static final String domain_health=PropertiesUtil.getStringProperty("domain_health", "");
    public static final String domain_disease=PropertiesUtil.getStringProperty("domain_disease", "");
    public static final String domain_fashion=PropertiesUtil.getStringProperty("domain_fashion", "");
    public static final String domain_drugs=PropertiesUtil.getStringProperty("domain_drugs", "");
    public static final String domain_care=PropertiesUtil.getStringProperty("domain_care", "");
    public static final String domain_news=PropertiesUtil.getStringProperty("domain_news", "");

    public static final String static_page_flag=PropertiesUtil.getStringProperty("static_page_flag", "####");
    public static final String turnpage_first=PropertiesUtil.getStringProperty("class.turnpage.first", "","UTF-8");
    public static final String turnpage_back=PropertiesUtil.getStringProperty("class.turnpage.back", "","UTF-8");
    public static final String turnpage_next=PropertiesUtil.getStringProperty("class.turnpage.next", "","UTF-8");
    public static final String turnpage_last=PropertiesUtil.getStringProperty("class.turnpage.last", "","UTF-8");
    
    public static final String delivery=PropertiesUtil.getStringProperty("class.orderhandlestatus_delivery", "","UTF-8");
    public static final String delivery_name=PropertiesUtil.getStringProperty("class.orderhandlestatus_delivery_"+delivery, "","UTF-8");
    public static final String cancel=PropertiesUtil.getStringProperty("class.orderhandlestatus_cancel", "","UTF-8");
    public static final String cancel_name=PropertiesUtil.getStringProperty("class.orderhandlestatus_cancel_"+cancel, "","UTF-8");
  
    public static final String ARTICLE_INDEX_DIR=PropertiesUtil.getStringProperty("article_index_dir", "");
    public static final String default_img_b=PropertiesUtil.getStringProperty("default_img_b", "");
    public static final String default_img_s=PropertiesUtil.getStringProperty("default_img_s", "");
    public static final String default_img_listb=PropertiesUtil.getStringProperty("default_img_listb", "");
    public static final String default_img_lists=PropertiesUtil.getStringProperty("default_img_lists", "");
    public static final String default_img_dp=PropertiesUtil.getStringProperty("default_img_dp", "");
    public static final String default_img_scroll_s=PropertiesUtil.getStringProperty("default_img_scroll_s", "");
    public static final String index_jkzx_code=PropertiesUtil.getStringProperty("index_jkzx_code", "");
    public static final String index_hyzx_code=PropertiesUtil.getStringProperty("index_hyzx_code", "");
    public static final String ws_url=PropertiesUtil.getStringProperty("ws_url", "");
    public static final String ws_namespace=PropertiesUtil.getStringProperty("ws_namespace", "");
    public static final String ws_method=PropertiesUtil.getStringProperty("ws_method", "");
    public static final String ws_namespace_name=PropertiesUtil.getStringProperty("ws_namespace_name", "");
    public static final String ws_response_name=PropertiesUtil.getStringProperty("ws_response_name", "");
    /**重建文章索引目录**/
    public static final String rebuild_article_index_dir=PropertiesUtil.getStringProperty("rebuild_article_index_dir", "");
    /**地区静态js文件**/
    public static final String rebuild_area_js_dir=PropertiesUtil.getStringProperty("rebuild_area_js_dir", "");
    
    public static final String Html_Make_Charset = PropertiesUtil.getStringProperty("html_make_charset", "");
    /**软文code**/
    public static final String rw_code = PropertiesUtil.getStringProperty("rw_code", "");
    
}
