package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.util.Log;



public class CallbackWebView extends WebView {
    private ContentHeightListener listener;
    int contentHeight = getContentHeight();

    public CallbackWebView(Context context) {
        super(context);
    }

    public CallbackWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CallbackWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setContentHeigthListener(ContentHeightListener listener) {
        this.listener = listener;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        // Scrolling in the webview will trigger invalidate. 
        // To prevent unnecessary updates we check if the contentheight has changed before triggering the onContentHeightUpdated callback
        if (getContentHeight() != contentHeight) {
            contentHeight = getContentHeight();
            if(listener!=null)
                listener.onContentHeightUpdated(getContentHeight());
        }
    }
}

