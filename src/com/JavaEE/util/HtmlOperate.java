package com.JavaEE.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.*;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Created by xfcq on 2016/5/28.
 */
public class HtmlOperate {
    public void htmlCode2pdf(String htmlCode, String pdfFile) throws Exception {
        InputStream htmlFileStream = new ByteArrayInputStream(htmlCode.getBytes("UTF-8"));
        BaseFont bfCN = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        // 中文字体定义
        Font chFont = new Font(bfCN, 12, Font.NORMAL, BaseColor.BLUE);
        Font secFont = new Font(bfCN, 12, Font.NORMAL, new BaseColor(0, 204, 255));

        Document document = new Document();
        PdfWriter pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
        pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);
        document.open();

//        int chNum = 1;
//        Chapter chapter = new Chapter(new Paragraph("HTML文件转PDF测试", chFont), chNum++);
//
//        Section section = chapter.addSection(new Paragraph("/dev/null 2&gt;&amp;1 详解", secFont));
//        // section.setNumberDepth(2);
//        // section.setBookmarkTitle("基本信息");
//        section.setIndentation(10);
//        section.setIndentationLeft(10);
//        section.setBookmarkOpen(false);
//        section.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
//        section.add(Chunk.NEWLINE);
//        document.add(chapter);

        // html文件
        InputStreamReader isr = new InputStreamReader(htmlFileStream, "UTF-8");

//         方法一：默认参数转换
        XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document, isr);

//         方法二：可以自定义参数
//         HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
//         htmlContext.charSet(Charset.forName("UTF-8"));
//         htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
//         CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
//         Pipeline pipeline = new CssResolverPipeline(cssResolver,
//            new HtmlPipeline(htmlContext, new PdfWriterPipeline(document,
//            pdfwriter)));
//         XMLWorker worker = new XMLWorker(pipeline, true);
//         XMLParser p = new XMLParser();
//         p.addListener(worker);
//
//         p.parse(isr);
//         p.flush();

        document.close();
    }
}