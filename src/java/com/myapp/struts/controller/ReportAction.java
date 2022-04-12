/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;

import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.ReportEngine;

/**
 *
 * @author willi
 */
public class ReportAction extends org.apache.struts.action.Action {

    public static String rptDesign = "D:/OneDrive - Universitas Diponegoro/00. KERJA BCA/Materi Teknis/08. Reporting Tools/Folder Project/BIT-ProjectStruts5Day/rpt1.rptdesign";
    public static String outputFile = "C:/Users/willi/Downloads/ReportBro.pdf";

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //        deklarasi parameter
        String act = request.getParameter("act");
        String month = request.getParameter("month");
        String year = request.getParameter("year");

        ReportEngine engine = null;
        EngineConfig config = new EngineConfig();

        try {
            engine = new ReportEngine(config);

            // Open the report design
            IReportRunnable design = null;
            design = engine.openReportDesign(rptDesign);

            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            // set parameters
            task.setParameterValue("tahun_app", year);
            task.setParameterValue("bulan_app", month);
            task.validateParameters();

            final HTMLRenderOption HTML_OPTIONS = new HTMLRenderOption();
            HTML_OPTIONS.setOutputFileName(outputFile);
            HTML_OPTIONS.setOutputFormat("pdf");
            task.setRenderOption(HTML_OPTIONS);
            task.run();
            task.close();
            engine.destroy();

            System.out.println("Report is generated successfully");
             return mapping.findForward(SUCCESS);
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            Platform.shutdown();
        }

        return mapping.findForward(FAILED);
    }
}
