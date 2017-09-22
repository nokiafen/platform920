package com.comba.android.combacommon.utils;

import android.content.Context;

/**
 * 
 * px to dip/sp or dip/sp to px.
 * @author  yinb
 * @version  [V1.0.0.0, 2013-5-9]
 */
public class DensityUtil {  
	  
	/**
	 * convert dip value to px value. 
	 * @param context the context.
	 * @param dpValue dip value.
	 * @return px value.
	 */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /**
     * convert px value to dip value. 
     * @param context the context.
     * @param pxValue px value.
     * @return dip value.
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }  
    
    
    /**
     * convert sp value to px value.
     * @param context the context.
     * @param spValue sp value.
     * @return px value.
     */
    public static int sp2px(Context context, float spValue) {
    	final float scale = context.getResources().getDisplayMetrics().scaledDensity;  
    	return (int) (spValue * scale + 0.5f);  
    }
    
    /**
     * convert px value to sp value.
     * @param context the context.
     * @param pxValue px value.
     * @return sp value.
     */
    public static int px2sp(Context context, float pxValue) {
    	final float scale = context.getResources().getDisplayMetrics().scaledDensity;
    	return (int) (pxValue / scale + 0.5f);
    }
    
}  