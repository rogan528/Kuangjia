package com.zhangbin.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Dialog工具类
 */
public class DialogUtils {

    /**
     * @param context
     * @param titleName dialog的标题文字
     * @param positiveName  积极按钮的文字(R.string.xxxxxx也可以String)
     * @param positiveListener
     * @param negativeName  取消按钮的文字(R.string.xxxxxx也可以String)
     * @param negativeListener
     */
    public static void showDialog(Context context,Object titleName,Object positiveName,final DialogInterface.OnClickListener positiveListener,Object negativeName,final DialogInterface.OnClickListener negativeListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String titleType = titleName.getClass().getSimpleName();
        String setTitleName ="";
        if("String".equals(titleType)){
            setTitleName = (String) titleName;
        } else if("Integer".equals(titleType)){
            setTitleName = (String) context.getResources().getText((Integer) titleName);
        }
        builder.setTitle(setTitleName);

        String positiveType = positiveName.getClass().getSimpleName();
        String setPositiveName ="";
        if("String".equals(positiveType)){
            setPositiveName = (String) positiveName;
        } else if("Integer".equals(positiveType)){
            setPositiveName = (String) context.getResources().getText((Integer) positiveName);
        }
        builder.setPositiveButton(setPositiveName, positiveListener);

        String negativeType = negativeName.getClass().getSimpleName();
        String setNegativeName ="";
        if("String".equals(negativeType)){
            setNegativeName = (String) negativeName;
        } else if("Integer".equals(negativeType)){
            setNegativeName = (String) context.getResources().getText((Integer) negativeName);
        }
        builder.setNegativeButton(setNegativeName,negativeListener);
        builder.show();
    }
}
