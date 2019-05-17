package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.util.Log;



public class MyWebView extends WebView {
    private ContentHeightListener listener;

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setContentHeigthListener(ContentHeightListener listener) {
        this.listener = listener;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        if (getContentHeight() > 0) {
            if(listener!=null)
                listener.onContentHeightUpdated(getContentHeight());
        }
    }
}

