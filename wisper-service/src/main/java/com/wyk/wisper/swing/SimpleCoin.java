package com.wyk.wisper.swing;

import java.applet.Applet;              //表示程序是Applet程序
import java.awt.BorderLayout;           //表示窗口环境采用BorderLayout方式进行布局

import com.sun.j3d.utils.geometry.Cone; //表示调用生成Cone的一个Utility，该包提供基本形体
import com.sun.j3d.utils.universe.*;    //表示调用一些设置基本的观测位置所用的类

import javax.media.j3d.*;               //表示调用程序所需的Java3d核心类，所有的Java3d程序必须带有这一条
import javax.vecmath.*;                 //表示调用程序所需的定义矢量计算所用的数学类

import com.sun.j3d.utils.applet.MainFrame;//可以使程序既为application也为applet
import java.awt.GraphicsConfiguration; //

public class SimpleCoin extends Applet {
    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();         //objRoot对象用于向程序的构造方法提供整个createSceneGraph方法里的内容
        TransformGroup objTrans = new TransformGroup();   //新建objTrans对象用于存放坐标系
        objRoot.addChild(objTrans);                     //缺省状况下Java3d的观察点位于(0,0,2.41)，所以这里objTrans两句不要也可运行成功

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0); //新建球形限制框，以坐标原点为中心，半径100

        Color3f bgColor = new Color3f(1.0f, 1.0f, 1.0f);   //设置背景色为白色
        Background bg = new Background(bgColor);         //设置背景对象bg的颜色为bgColor
        bg.setApplicationBounds(bounds);               //设置背景应用范围为bounds
        objRoot.addChild(bg);                          //将背景对象bg添加到objRoot对象中

        Color3f directionalColor = new Color3f(1.f, 0.f, 0.f);//设置光源为绿色
        Vector3f vec = new Vector3f(-1.f, 0.f, -1.f);          //设置光源为-Z方向
        DirectionalLight directionalLight = new DirectionalLight(directionalColor, vec);//使用直接光照
        directionalLight.setInfluencingBounds(bounds);    //设置光照影响范围为bounds
        objRoot.addChild(directionalLight);               //将光照对象添加到objRoot中

        Appearance app = new Appearance();
        Material material = new Material();
        //material.setEmissiveColor(new Color3f(1.0f,0.0f,0.0f));//外观 无光照条件下 材质为辐射颜色，设置为红色
        material.setDiffuseColor(new Color3f(1.0f, 1.0f, 0.0f));   //有光照条件下，材质为漫反射颜色，设置为黄色
        app.setMaterial(material);                               //设置材质material到对象app，material为空会使光照失效

        Cone cone = new Cone(.5f, 1.0f, 1, app);//绘制半径为0.5,高为1.0的圆锥，片元标记为1，外观为app（其中已为圆锥体设置了材质属性）
        objTrans.addChild(cone);

        objRoot.compile();
        return objRoot;
    }

    public SimpleCoin() {
        setLayout(new BorderLayout());
        //Canvas3D c=new Canvas3D(null);
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D c = new Canvas3D(config);
        //将上一句换成以上两句；记得导入import java.awt.GraphicsConfiguration；
        add("Center", c);//applet的方法，用于将指定组件（画布c）添加到该容器（applet）中
        BranchGroup scene = createSceneGraph();
        SimpleUniverse u = new SimpleUniverse(c);                   //以3d画布实例c创建一个局部单一的查看平台和一个观察者对象
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);

    }

    public static void main(String args[]) {
        new MainFrame(new SimpleCoin(), 400, 300);
    }

}