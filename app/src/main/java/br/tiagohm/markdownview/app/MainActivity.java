package br.tiagohm.markdownview.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.InternalStyleSheet;
import br.tiagohm.markdownview.css.styles.Github;

public class MainActivity extends AppCompatActivity {
  private MarkdownView mMarkdownView;
  private InternalStyleSheet mStyle = new Github();

  LinearLayout linearLayout;

  private WebView webContent;

  private WebChromeClient.CustomViewCallback myCallBack;

  private View myView;

  private FrameLayout videoContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    linearLayout = (LinearLayout) findViewById(R.id.ll);
    videoContainer = (FrameLayout) findViewById(R.id.videoContainer);
    mMarkdownView = (MarkdownView) findViewById(R.id.mark_view);
    mStyle.addMedia("screen and (min-width: 320px)");
    mStyle.addRule("h1", "color: green");
    mStyle.endMedia();

    //一定要在MarkdownView设置数据方法之前
    mMarkdownView.setOnRenderedListener(new MarkdownView.OnRenderedListener() {
      @Override
      public void onRendered() {
        Toast.makeText(MainActivity.this, "渲染完了", Toast.LENGTH_SHORT).show();
      }
    });

//        mMarkdownView.addStyleSheet(mStyle);
    mMarkdownView.loadMarkdownFromAsset("test6.md");
  }
}
