###### 使用说明

首先添加仓库地址:
```
maven { url 'https://jitpack.io' }
```

项目中添加库引用:
```
implementation 'com.github.SpeedataG:Mvp:1.1'
```

推荐先安装MvpHelper插件

创建contract包
创建Contract类，打上类名使用快捷键 Alt+Insert选择Mvp Helper会自动生成文件

```
public interface MainContract {
    interface Model {
    }

    interface View {
    }

    interface Presenter {
    }
}
```

实现Model类
```
public class MainModel extends BaseModel implements MainContract.Model {
}
```

实现Presenter类
```
public class MainPresenter extends BasePresenter<MainActivity, MainModel> implements MainContract.Presenter {
    @Override
    protected MainModel createModel() {
        return new MainModel();
    }
}
```

实现Activity类
```
public class MainActivity extends BaseMvpActivity<MainPresenter> {


    @Override
    protected int getActLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }
}
```

修改状态栏颜色
```
<color name="colorPrimaryDark">#222222</color>
```
修改标题栏颜色
```
<color name="colorPrimary">#FFFFFF</color>
```
设置Toolbar
```
@Override
    protected void initToolbar() {
        super.initToolbar();
        //隐藏toolbar
        mToolBar.setVisibility(View.GONE);
        //设置返回键样式
        mToolBar.setNavigationIcon(R.mipmap.ic_launcher);
    }
```

设置标题
```
方法1：mToolbarTitle.setText("标题");

方法2:
AndroidManifest.xml对应activity中添加
android:label="标题"

```
