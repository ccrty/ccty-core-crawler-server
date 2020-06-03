package com.ccty.noah.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.io.StringWriter;


/**
 * @author 缄默
 * @date 2019/12/16
 */
public class XmlToJson {

    public static void main(String[] args) {
        System.out.println(convertXmlIntoJSONObject("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<doc xmlns=\"http://www.ibm.com/iis/flow-doc\">\n" +
                "    <assets>\n" +
                "        <asset class=\"$hkbappsystems-appsystem\" repr=\"核心系统\" ID=\"ID_5b818a0c.187019e4.0gomudmlr.19dcg4q.flmdho.jvd8ljbgj0oqun5j3to7r\">\n" +
                "            <attribute name=\"name\" value=\"核心系统\"/>\n" +
                "            <attribute name=\"short_description\" value=\"short description of the system\"/>\n" +
                "            <attribute name=\"long_description\" value=\" long description of the system\"/>\n" +
                "            <attribute name=\"$eng_name\" value=\"core\"/>\n" +
                "            <attribute name=\"$ip_addr\">\n" +
                "                <multiValueItem>10.1.1.1</multiValueItem>\n" +
                "            </attribute>\n" +
                "            <reference name=\"custom_回归环境数据库\" identityPart=\"false\" externalAssetIDs=\"ID_b1c497ce.6e83759b.0gomqe94c.kjg49jv.igu31p.setkrhblj19h7ncu7b27r\"/>\n" +
                "            <reference name=\"custom_数据平台模式\" identityPart=\"false\" externalAssetIDs=\"ID_b1c497ce.c1fb060b.0gomqs3tj.8flmbjs.89l0p8.0cs873h6nnm6dnh5v9omi\"/>\n" +
                "        </asset>\n" +
                "        <asset class=\"$hkbappsystems-appsystem\" repr=\"财务系统\" ID=\"ID_5b818a0c.187019e4.0gomudmkp.hackn3d.k405t3.ktobp5cesti1n3p1i2dol\">\n" +
                "            <attribute name=\"name\" value=\"财务系统\"/>\n" +
                "            <attribute name=\"short_description\" value=\"short description of the system\"/>\n" +
                "            <attribute name=\"long_description\" value=\" long description of the system\"/>\n" +
                "            <attribute name=\"$eng_name\" value=\"xxx\"/>\n" +
                "            <attribute name=\"$ip_addr\">\n" +
                "                <multiValueItem>10.1.1.2</multiValueItem>\n" +
                "            </attribute>\n" +
                "        </asset>\n" +
                "        <asset class=\"$hkbappsystems-dqissue\" repr=\"测试问题1\" ID=\"ID_5b818a0c.187019e4.0gomudmlr.1dlr8lo.ndfqvl.mkbc5cafe6ar61n45bv77\">\n" +
                "            <attribute name=\"name\" value=\"测试问题1\"/>\n" +
                "            <attribute name=\"short_description\" value=\"short description of the system\"/>\n" +
                "            <attribute name=\"long_description\" value=\" long description of the system\"/>\n" +
                "            <attribute name=\"$found_date\" value=\"2019-02-02\"/>\n" +
                "            <attribute name=\"$finder\">\n" +
                "                <multiValueItem>殷达</multiValueItem>\n" +
                "            </attribute>\n" +
                "            <reference name=\"$appsystem\" assetIDs=\"ID_5b818a0c.187019e4.0gomudmlr.19dcg4q.flmdho.jvd8ljbgj0oqun5j3to7r\"/>\n" +
                "        </asset>\n" +
                "        <asset class=\"$hkbappsystems-dqissue\" repr=\"测试问题3\" ID=\"ID_5b818a0c.187019e4.0gomudmkp.i2riv14.radiji.j61fvjms5qcgscmb9peal\">\n" +
                "            <attribute name=\"name\" value=\"测试问题3\"/>\n" +
                "            <attribute name=\"short_description\" value=\"short description of the system\"/>\n" +
                "            <attribute name=\"long_description\" value=\" long description of the system\"/>\n" +
                "            <attribute name=\"$found_date\" value=\"2019-02-02\"/>\n" +
                "            <attribute name=\"$finder\">\n" +
                "                <multiValueItem>殷达</multiValueItem>\n" +
                "            </attribute>\n" +
                "            <reference name=\"$appsystem\" assetIDs=\"ID_5b818a0c.187019e4.0gomudmkp.hackn3d.k405t3.ktobp5cesti1n3p1i2dol\"/>\n" +
                "        </asset>\n" +
                "        <asset class=\"$hkbappsystems-dqissue\" repr=\"测试问题2\" ID=\"ID_5b818a0c.187019e4.0gomudmlr.1fpk9n6.p9ob36.4e9fv9d8b4837omuhb52n\">\n" +
                "            <attribute name=\"name\" value=\"测试问题2\"/>\n" +
                "            <attribute name=\"short_description\" value=\"short description of the system\"/>\n" +
                "            <attribute name=\"long_description\" value=\" long description of the system\"/>\n" +
                "            <attribute name=\"$found_date\" value=\"2019-02-03\"/>\n" +
                "            <attribute name=\"$finder\">\n" +
                "                <multiValueItem>林闵英</multiValueItem>\n" +
                "            </attribute>\n" +
                "            <reference name=\"$appsystem\" assetIDs=\"ID_5b818a0c.187019e4.0gomudmkp.hackn3d.k405t3.ktobp5cesti1n3p1i2dol\"/>\n" +
                "        </asset>\n" +
                "    </assets>\n" +
                "    <externalAssets>\n" +
                "        <labels/>\n" +
                "        <terms/>\n" +
                "        <categories/>\n" +
                "        <rules/>\n" +
                "        <stewards/>\n" +
                "        <detached>\n" +
                "            <asset class=\"host\" repr=\"DB2_BAK\" ID=\"ID_b1c497ce.354f5217.0gomqe94c.kjg3psu.3sl2fv.n5rh2jqlottudkte9ucrb\">\n" +
                "                <attribute name=\"name\" value=\"DB2_BAK\"/>\n" +
                "            </asset>\n" +
                "            <asset class=\"database\" repr=\"col_t1\" ID=\"ID_b1c497ce.6e83759b.0gomqn0b9.vk71bq9.9q012c.aaq1i2gnnopc9qrc6kt20\">\n" +
                "                <attribute name=\"name\" value=\"col_t1\"/>\n" +
                "                <reference name=\"host\" externalAssetIDs=\"ID_b1c497ce.354f5217.0gomqn0b9.vjmlnhe.5kvble.c0f8k0c7pidpcli24jdrb\"/>\n" +
                "            </asset>\n" +
                "            <asset class=\"host\" repr=\"ORACLE_HOST\" ID=\"ID_b1c497ce.354f5217.0gomqn0b9.vjmlnhe.5kvble.c0f8k0c7pidpcli24jdrb\">\n" +
                "                <attribute name=\"name\" value=\"ORACLE_HOST\"/>\n" +
                "            </asset>\n" +
                "            <asset class=\"database\" repr=\"TIGER\" ID=\"ID_b1c497ce.6e83759b.0gomqe94c.kjg49jv.igu31p.setkrhblj19h7ncu7b27r\">\n" +
                "                <attribute name=\"name\" value=\"TIGER\"/>\n" +
                "                <reference name=\"host\" externalAssetIDs=\"ID_b1c497ce.354f5217.0gomqe94c.kjg3psu.3sl2fv.n5rh2jqlottudkte9ucrb\"/>\n" +
                "            </asset>\n" +
                "            <asset class=\"database_schema\" repr=\"AMLM\" ID=\"ID_b1c497ce.c1fb060b.0gomqs3tj.8flmbjs.89l0p8.0cs873h6nnm6dnh5v9omi\">\n" +
                "                <attribute name=\"name\" value=\"AMLM\"/>\n" +
                "                <reference name=\"database\" externalAssetIDs=\"ID_b1c497ce.6e83759b.0gomqn0b9.vk71bq9.9q012c.aaq1i2gnnopc9qrc6kt20\"/>\n" +
                "            </asset>\n" +
                "        </detached>\n" +
                "    </externalAssets>\n" +
                "    <importAction partialAssetIDs=\"ID_5b818a0c.187019e4.0gomudmlr.19dcg4q.flmdho.jvd8ljbgj0oqun5j3to7r ID_5b818a0c.187019e4.0gomudmkp.hackn3d.k405t3.ktobp5cesti1n3p1i2dol ID_5b818a0c.187019e4.0gomudmlr.1dlr8lo.ndfqvl.mkbc5cafe6ar61n45bv77 ID_5b818a0c.187019e4.0gomudmkp.i2riv14.radiji.j61fvjms5qcgscmb9peal ID_5b818a0c.187019e4.0gomudmlr.1fpk9n6.p9ob36.4e9fv9d8b4837omuhb52n\"/>\n" +
                "</doc>"));
    }

    /**
     * 传入字符串格式的xml
     * 将xml格式<a/>装换成<a></a>
     * 再将xml装换成属性没有带"@"的JSONObject格式
     * @param xml
     * @return jsonObject
     * */
    public static JSONObject convertXmlIntoJSONObject (String xml){
        JSONObject jsonObject=new JSONObject();
        try {
            Document xmlDocument = DocumentHelper.parseText(xml);
            OutputFormat format = new OutputFormat();
            format.setEncoding("UTF-8");
            format.setExpandEmptyElements(true);
            StringWriter out = new StringWriter();
            XMLWriter writer = new XMLWriter(out, format);
            try {
                writer.write(xmlDocument);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //out.toString() 此结果为xml的<a></a>格式
            jsonObject=XML.toJSONObject(out.toString());
        } catch (DocumentException e1) {
            e1.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
