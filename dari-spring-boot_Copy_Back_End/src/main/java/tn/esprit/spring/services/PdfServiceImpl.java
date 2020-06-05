package tn.esprit.spring.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;

import tn.esprit.spring.entities.LoanSimulation;

@Service
public class PdfServiceImpl implements IPdfService {

	@Autowired
	private ILoanSimulationService loanSimulationService;
	
	
	
	@Override
	public String toPDF(Long idSimulation) {
		
		String URL_file = null;
		
		LoanSimulation simulation=loanSimulationService.getSimulationById(idSimulation);
		
		 Date d = new Date();
         SimpleDateFormat formater = null;
         formater = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try {
			try {
				try {
					try {

	                        URL_file = "C:\\Users\\ASUS\\Documents\\ESTIMATION_" + idSimulation + "_"+formater.format(d)+".pdf";
	                        OutputStream file = new FileOutputStream(new File(URL_file));
//	                        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.DARK_GRAY);
//	                        Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
	                        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GRAY);
	                        Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
//	                        Font catFont17B = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
	                        Font catFont17Bcour = new Font(Font.FontFamily.COURIER, 17, Font.BOLD, BaseColor.BLACK);
//	                        Font catFont14N = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
//	                        Font catFont14B = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
//	                        Font catFont14Bcour = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
	                        Font subFontPara13B = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
//	                        Font subFontPara12Ncour = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.BLACK);
//	                        Font subFontPara12CScour = new Font(Font.FontFamily.COURIER, 14, Font.UNDERLINE | Font.BOLD , BaseColor.BLACK);
//	                        Font subFontPara12Bcour = new Font(Font.FontFamily.COURIER, 12, Font.BOLD , BaseColor.BLACK);
	                        Font subFontPara13N= new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
	                        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
	                        
	                        Document my_pdf_report = new Document();
	                        PdfWriter.getInstance(my_pdf_report, file);
	                        my_pdf_report.open();
	                        
	                        
	                        ///Imageee
	                        Image imgBank = null;
	                        if (simulation.getBank().getName().equals("UIB")){
	                         imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\uib.jpg");}
	                        
	                        if (simulation.getBank().getName().equals("BIAT")){
		                      imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\biat.jpg");}
	                        
	                        if (simulation.getBank().getName().equals("UBCI")){
			                      imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\ubci.jpg");}
	                        
	                        if (simulation.getBank().getName().equals("ATTIJARI")){
			                      imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\attijari.jpg");}
	                        
	                        //767
	                        imgBank.setAbsolutePosition(50,769);
	                        imgBank.scaleAbsolute(70,50);

	                        //Dateeee
	                        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
	                        String dt = df.format(new Date());
	                        Paragraph dateStr = new Paragraph(dt, catFont15B);
		                      //separator
	                        Paragraph separator1 = new Paragraph("_______________________________________________________________________________" , subFontPara13N);
	                        
	                        Paragraph titre=new Paragraph("ESTIMATION_" + idSimulation + "_"+formater.format(d));
	                        Paragraph titreBank = new Paragraph(simulation.getBank().getName()+" BANK",catFont15B);
	                        dateStr.setAlignment(Element.ALIGN_RIGHT);
	                        titreBank.setAlignment(Element.ALIGN_RIGHT);
	                        separator1.setAlignment(Element.ALIGN_RIGHT);
	                        titre.setAlignment(Element.ALIGN_RIGHT);
						
	                        
	                      //espaceee
	                        Paragraph espace = new Paragraph(" ", subFont);
	                        espace.setAlignment(Element.ALIGN_LEFT);
	                       
	                        //para1
	                        Paragraph para1 = new Paragraph("Miss/Mr " + simulation.getClient().getFirstName() +" " + simulation.getClient().getLastname() , catFont15B);
	                        para1.setAlignment(Element.ALIGN_LEFT);
	                        Paragraph para2 = new Paragraph("We are happy for your trust and we hope you are doing well. We provide you"
	                        		+ " an estimation of your loan request." , subFontPara13N);
	                        para2.setAlignment(Element.ALIGN_LEFT);
	                        
	                        
	                      //titreee
	                        Paragraph titre1 = new Paragraph("DETAILS ABOUT YOU" , catFont15B);
	                        titre1.setAlignment(Element.ALIGN_CENTER);
	                        
	                        
	                        PdfPTable table = new PdfPTable(4);
	                        table.setWidthPercentage(90);
	                        table.setHorizontalAlignment(Element.ALIGN_LEFT);;
	                        
	                        ///Ligne 1
	                        PdfPCell  Cellnom = new PdfPCell(new Phrase("First Name & Last Name", subFontPara13B));
	                        Cellnom.setBorder(Rectangle.NO_BORDER);
	                        Cellnom.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell CellnomR = new PdfPCell(new Phrase( ": " + simulation.getClient().getFirstName() +" " +simulation.getClient().getLastname() , subFontPara13N));
	                        CellnomR.setBorder(Rectangle.NO_BORDER);
	                        CellnomR.setBackgroundColor(BaseColor.WHITE);
	                        CellnomR.setColspan(3);


	                        table.addCell(Cellnom);
	                        table.addCell(CellnomR);

	                        PdfPCell CellnomRN = new PdfPCell( new Phrase(""));
	                        CellnomRN.setBorder(Rectangle.NO_BORDER);
	                        CellnomRN.setBackgroundColor(BaseColor.WHITE);

	                        //space
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        
	                        
	                    /////Ligne 2
	                        PdfPCell  CellCin = new PdfPCell(new Phrase("Email", subFontPara13B));
	                        CellCin.setBorder(Rectangle.NO_BORDER);
	                        CellCin.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell CellCinR = new PdfPCell(new Phrase( ": " +simulation.getClient().getEmail(), subFontPara13N));
	                        CellCinR.setBorder(Rectangle.NO_BORDER);
	                        CellCinR.setBackgroundColor(BaseColor.WHITE);
	                        CellCinR.setColspan(3);

	                        table.addCell(CellCin);
	                        table.addCell(CellCinR);
	                        
	                        //space
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        
	                    /////Ligne 3
	                        PdfPCell  CellEmail = new PdfPCell(new Phrase("National identiy carte ", subFontPara13B));
	                        CellEmail.setBorder(Rectangle.NO_BORDER);
	                        CellEmail.setBackgroundColor(BaseColor.WHITE);


	                        PdfPCell CellEmailR = new PdfPCell(new Phrase( ": " +simulation.getClient().getCin(), subFontPara13N));
	                        CellEmailR.setBorder(Rectangle.NO_BORDER);
	                        CellEmailR.setBackgroundColor(BaseColor.WHITE);
	                        CellEmailR.setColspan(3);


	                        table.addCell(CellEmail);
	                        table.addCell(CellEmailR);


	                        //space
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);


	                       
//	                        /////Ligne 4
//	                        PdfPCell  CelAdr = new PdfPCell(new Phrase("Téléphone", subFontPara13B));
//	                        CelAdr.setBorder(Rectangle.NO_BORDER);
//	                        CelAdr.setBackgroundColor(BaseColor.WHITE);
//
//	                        PdfPCell CelAdrr = new PdfPCell(new Phrase( ": " +simulation.getClient().get , subFontPara13N));
//	                        CelAdrr.setBorder(Rectangle.NO_BORDER);
//	                        CelAdrr.setBackgroundColor(BaseColor.WHITE);
//	                        CelAdrr.setColspan(3);
//
//	                        table.addCell(CelAdr);
//	                        table.addCell(CelAdrr);


//	                        //space
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
	                        
	                   
	                        
	                        
//	                        /////Ligne 5
//	                        PdfPCell  Celjob = new PdfPCell(new Phrase("Profession ", subFontPara13B));
//	                        Celjob.setBorder(Rectangle.NO_BORDER);
//	                        Celjob.setBackgroundColor(BaseColor.WHITE);
//
//	                        PdfPCell Celjobb = new PdfPCell(new Phrase( ": " +c.getCustomer().getJob(), subFontPara13N));
//	                        Celjobb.setBorder(Rectangle.NO_BORDER);
//	                        Celjobb.setBackgroundColor(BaseColor.WHITE);
//	                        Celjobb.setColspan(3);
//
//	                        table.addCell(Celjob);
//	                        table.addCell(Celjobb);
//
//
//	                        //space
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
	                        
	                        
	                    /////Ligne 6
	                        PdfPCell  Celsal = new PdfPCell(new Phrase("Your Salary ", subFontPara13B));
	                        Celsal.setBorder(Rectangle.NO_BORDER);
	                        Celsal.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell Celsall = new PdfPCell(new Phrase( ": " +simulation.getSalaire(), subFontPara13N));
	                        Celsall.setBorder(Rectangle.NO_BORDER);
	                        Celsall.setBackgroundColor(BaseColor.WHITE);
	                        Celsall.setColspan(3);

	                        table.addCell(Celsal);
	                        table.addCell(Celsall);


	                        //space
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        
	                        
	                        
	                        
	                      //separator
	                        Paragraph separator = new Paragraph("_________________________________________________________" , subFontPara13N);
	                        separator.setAlignment(Element.ALIGN_CENTER);
	                        
	                      //titreee
	                        Paragraph titre2 = new Paragraph("DETAILS ABOUT BANK " , catFont15B);
	                        titre2.setAlignment(Element.ALIGN_CENTER);
	                        
	                        
	                        
	                        PdfPTable table1 = new PdfPTable(4);
	                        table1.setWidthPercentage(90);
	                        
	                        ///Ligne 1
	                        PdfPCell  Cellnomb = new PdfPCell(new Phrase("Name", subFontPara13B));
	                        Cellnomb.setBorder(Rectangle.NO_BORDER);
	                        Cellnomb.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell CellnombR = new PdfPCell(new Phrase( ": " + simulation.getBank().getName() , subFontPara13N));
	                        CellnombR.setBorder(Rectangle.NO_BORDER);
	                        CellnombR.setBackgroundColor(BaseColor.WHITE);
	                        CellnombR.setColspan(3);


	                        table1.addCell(Cellnomb);
	                        table1.addCell(CellnombR);

	                        PdfPCell CellnombRN = new PdfPCell( new Phrase(""));
	                        CellnombRN.setBorder(Rectangle.NO_BORDER);
	                        CellnombRN.setBackgroundColor(BaseColor.WHITE);

	                        //space
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        
	                        
	                    /////Ligne 2
	                        PdfPCell  Cellt= new PdfPCell(new Phrase("Agent", subFontPara13B));
	                        Cellt.setBorder(Rectangle.NO_BORDER);
	                        Cellt.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell Celltt = new PdfPCell(new Phrase( ": " +simulation.getBank().getAgentBank().getFirstName()+" "+simulation.getBank().getAgentBank().getLastname(), subFontPara13N));
	                        Celltt.setBorder(Rectangle.NO_BORDER);
	                        Celltt.setBackgroundColor(BaseColor.WHITE);
	                        Celltt.setColspan(3);

	                        table1.addCell(Cellt);
	                        table1.addCell(Celltt);
	                        
	                        //space
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        
	                    /////Ligne 3
	                        PdfPCell CelAdr1 = new PdfPCell(new Phrase("Address ", subFontPara13B));
	                        CelAdr1.setBorder(Rectangle.NO_BORDER);
	                        CelAdr1.setBackgroundColor(BaseColor.WHITE);


	                        PdfPCell CelAdrr1 = new PdfPCell(new Phrase( ": " +simulation.getBank().getAddress(), subFontPara13N));
	                        CelAdrr1.setBorder(Rectangle.NO_BORDER);
	                        CelAdrr1.setBackgroundColor(BaseColor.WHITE);
	                        CelAdrr1.setColspan(3);


	                        table1.addCell(CelAdr1);
	                        table1.addCell(CelAdrr1);


	                      //space
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);


	                       
	                        /////Ligne 4
	                        PdfPCell  Celtm = new PdfPCell(new Phrase("T.M.M.", subFontPara13B));
	                        Celtm.setBorder(Rectangle.NO_BORDER);
	                        Celtm.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell Celtmm = new PdfPCell(new Phrase( ": " +simulation.getBank().getTauxMoyenDuMarche() , subFontPara13N));
	                        Celtmm.setBorder(Rectangle.NO_BORDER);
	                        Celtmm.setBackgroundColor(BaseColor.WHITE);
	                        Celtmm.setColspan(3);

	                        table1.addCell(Celtm);
	                        table1.addCell(Celtmm);


	                      //space
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                   
	                        
	                        
	                        /////Ligne 5
	                        PdfPCell  Celmarg = new PdfPCell(new Phrase("Marge ", subFontPara13B));
	                        Celmarg.setBorder(Rectangle.NO_BORDER);
	                        Celmarg.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell Celmargg = new PdfPCell(new Phrase( ": " +simulation.getBank().getMargeInteret(), subFontPara13N));
	                        Celmargg.setBorder(Rectangle.NO_BORDER);
	                        Celmargg.setBackgroundColor(BaseColor.WHITE);
	                        Celmargg.setColspan(3);

	                        table1.addCell(Celmarg);
	                        table1.addCell(Celmargg);


	                      //space
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        table1.addCell(CellnombRN);
	                        
	                        
	                      //fiin P1
	                        Paragraph finPage1 = new Paragraph(" DARI IMMOBILIER Group (c) 2020" , smallBold);
	                        finPage1.setAlignment(Element.ALIGN_RIGHT);

////////////////////////////Paageeeeeeeeeeeeeeeeee 2
                        Paragraph titre21 = new Paragraph("ESTIMATION : " , catFont17Bcour);
                        titre21.setAlignment(Element.ALIGN_CENTER);
	                        
                        
                        PdfPTable table4 = new PdfPTable(2); // Create 2 columns in table.
                        
                        // Create cells
                        PdfPCell cell1 = new PdfPCell(new Paragraph("Rate"));
                        PdfPCell cell2 = new PdfPCell(new Paragraph(""+simulation.getTaux()));
                        PdfPCell cell3 = new PdfPCell(new Paragraph("Monthly rate"));
                        PdfPCell cell4 = new PdfPCell(new Paragraph("" +simulation.getMensuel() ));
                        PdfPCell cell5 = new PdfPCell(new Paragraph("Repayment Capacity"));
                        PdfPCell cell6 = new PdfPCell(new Paragraph("" +simulation.getCapaciteDeRembouresement()));
                        PdfPCell cell7 = new PdfPCell(new Paragraph("Monthly Payment"));
                        PdfPCell cell8 = new PdfPCell(new Paragraph("" +simulation.getMensualite()));
                        PdfPCell cell9 = new PdfPCell(new Paragraph("Interest"));
                        PdfPCell cell10 = new PdfPCell(new Paragraph("" +simulation.getInteret()));
                        PdfPCell cell11 = new PdfPCell(new Paragraph("Princper"));
                        PdfPCell cell12 = new PdfPCell(new Paragraph("" +simulation.getPrincipale()));
                        PdfPCell cell13 = new PdfPCell(new Paragraph("Refund Amount"));
                        PdfPCell cell14 = new PdfPCell(new Paragraph("" +simulation.getMontantRembourse()));
                        PdfPCell cell15 = new PdfPCell(new Paragraph("Total Interest"));
                        PdfPCell cell16 = new PdfPCell(new Paragraph("" +simulation.getInteretTotale()));

       
                         // Add cells in table
                        table4.addCell(cell1);
                        table4.addCell(cell2);
                        table4.addCell(cell3);
                        table4.addCell(cell4);
                        table4.addCell(cell5);
                        table4.addCell(cell6);
                        table4.addCell(cell7);
                        table4.addCell(cell8);
                        table4.addCell(cell9);
                        table4.addCell(cell10);
                        table4.addCell(cell11);
                        table4.addCell(cell12);
                        table4.addCell(cell13);
                        table4.addCell(cell14);
                        table4.addCell(cell15);
                        table4.addCell(cell16);
                        
                        
//                        table.addCell(cell1);
//                        table.addCell(cell2);
//                        table.addCell(cell3);
//                        table.addCell(cell4);
//                        table.addCell(cell5);
//                        table.addCell(cell6);
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
//                        ///////table 1
//                        PdfPTable tableLog = new PdfPTable(4);
//                        tableLog.setWidthPercentage(50);
//                        PdfPCell  Celog = new PdfPCell(new Phrase("Rate", catFont14Bcour));
//                        Celog.setPadding(12);
//                        Celog.setColspan(2);
//                        Celog.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celog.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell Celogr = new PdfPCell(new Phrase( "" +simulation.getTaux() , subFontPara13N));
//                        Celogr.setPadding(12);
//                        Celogr.setColspan(2);
//
//                        Celogr.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celogr.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableLog.addCell(Celog);
//                        tableLog.addCell(Celogr);
//                        
//                        
//                  ///////table 2
//                        PdfPTable tabletm = new PdfPTable(4);
//                        tabletm.setWidthPercentage(50);
//
//                        PdfPCell  Celtm1 = new PdfPCell(new Phrase("Monthly rate", catFont14Bcour));
//                        Celtm1.setPadding(12);
//                        Celtm1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celtm1.setVerticalAlignment(Element.ALIGN_RIGHT);
//                        Celtm1.setColspan(2);
//                        
//                        PdfPCell Celtmm1 = new PdfPCell(new Phrase( "" +simulation.getMensuel() , subFontPara13N));
//                        Celtmm1.setPadding(12);
//                        Celtmm1.setColspan(2);
//                        Celtmm1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celtmm1.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tabletm.addCell(Celtm1);
//                        tabletm.addCell(Celtmm1);
//                        
////                        ///////table 3
////                        PdfPTable tableEch = new PdfPTable(4);
////                        tableEch.setWidthPercentage(50);
////
////                        PdfPCell  Celech = new PdfPCell(new Phrase("Nombre D'echeance", catFont14Bcour));
////                        Celech.setPadding(12);
////                        Celech.setColspan(2);
////                        Celech.setHorizontalAlignment(Element.ALIGN_CENTER);
////                        Celech.setVerticalAlignment(Element.ALIGN_MIDDLE);
////
////                        PdfPCell Celechh = new PdfPCell(new Phrase( "" +estimation.getNombreEcheance() , subFontPara13N));
////                        Celechh.setPadding(12);
////                        Celechh.setColspan(2);
////                        Celechh.setHorizontalAlignment(Element.ALIGN_CENTER);
////                        Celechh.setVerticalAlignment(Element.ALIGN_MIDDLE);
////
////                        tableEch.addCell(Celech);
////                        tableEch.addCell(Celechh);
//                        
//                  ///////table 4
//                        PdfPTable tableCap = new PdfPTable(4);
//                        tableCap.setWidthPercentage(50);
//
//                        PdfPCell  CelCapR = new PdfPCell(new Phrase("Repayment Capacity", catFont14Bcour));
//                        CelCapR.setPadding(12);
//                        CelCapR.setColspan(2);
//                        CelCapR.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelCapR.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelCapRr = new PdfPCell(new Phrase( "" +simulation.getCapaciteDeRembouresement() , subFontPara13N));
//                        CelCapRr.setPadding(12);
//                        CelCapRr.setColspan(2);
//                        CelCapRr.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelCapRr.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableCap.addCell(CelCapR);
//                        tableCap.addCell(CelCapRr);
//                        
//                  ///////table 5
//                        PdfPTable tableMens = new PdfPTable(4);
//                        tableMens.setWidthPercentage(50);
//
//                        PdfPCell  CelMens = new PdfPCell(new Phrase("Monthly Payment", catFont14Bcour));
//                        CelMens.setPadding(12);
//                        CelMens.setColspan(2);
//                        CelMens.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMens.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//                        PdfPCell CelMenss = new PdfPCell(new Phrase( "" +simulation.getMensualite() , subFontPara13N));
//                        CelMenss.setPadding(12);
//                        CelMenss.setColspan(2);
//                        CelMenss.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMenss.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableMens.addCell(CelMens);
//                        tableMens.addCell(CelMenss);
//                        
//                        
//                  ///////table 6
//                        PdfPTable tableInteret = new PdfPTable(4);
//                        tableInteret.setWidthPercentage(50);
//
//                        PdfPCell  CelInt = new PdfPCell(new Phrase("Interest", catFont14Bcour));
//                        CelInt.setPadding(12);
//                        CelInt.setColspan(2);
//                        CelInt.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelInt.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelIntt = new PdfPCell(new Phrase( "" +simulation.getInteret() , subFontPara13N));
//                        CelIntt.setPadding(12);
//                        CelIntt.setColspan(2);
//                        CelIntt.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelIntt.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableInteret.addCell(CelInt);
//                        tableInteret.addCell(CelIntt);
//                        
//                        
//                        ///////table 7
//                        PdfPTable tablePrincper = new PdfPTable(4);
//                        tablePrincper.setWidthPercentage(50);
//
//                        PdfPCell  CelPrincper = new PdfPCell(new Phrase("Princper", catFont14Bcour));
//                        CelPrincper.setPadding(12);
//                        CelPrincper.setColspan(2);
//                        CelPrincper.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelPrincper.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelPrincperr = new PdfPCell(new Phrase( "" +simulation.getPrincipale() , subFontPara13N));
//                        CelPrincperr.setPadding(12);
//                        CelPrincperr.setColspan(2);
//                        CelPrincperr.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelPrincperr.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tablePrincper.addCell(CelPrincper);
//                        tablePrincper.addCell(CelPrincperr);
//                        
//                        ///////table 8
//                        PdfPTable tableMtRemboursent = new PdfPTable(4);
//                        tableMtRemboursent.setWidthPercentage(50);
//
//                        PdfPCell  CelMtRemboursent = new PdfPCell(new Phrase("Refund Amount", catFont14Bcour));
//                        CelMtRemboursent.setPadding(12);
//                        CelMtRemboursent.setColspan(2);
//                        CelMtRemboursent.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMtRemboursent.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelMtRemboursentt = new PdfPCell(new Phrase( "" +simulation.getMontantRembourse() , subFontPara13N));
//                        CelMtRemboursentt.setPadding(12);
//                        CelMtRemboursentt.setColspan(2);
//                        CelMtRemboursentt.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMtRemboursentt.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableMtRemboursent.addCell(CelMtRemboursent);
//                        tableMtRemboursent.addCell(CelMtRemboursentt);
//                        
//                        ///////table 9
//                        PdfPTable tableInteretTotal = new PdfPTable(4);
//                        tableInteretTotal.setWidthPercentage(50);
//
//                        PdfPCell  CelInteretTotal = new PdfPCell(new Phrase("Total Interest", catFont14Bcour));
//                        CelInteretTotal.setPadding(12);
//                        CelInteretTotal.setColspan(2);
//                        CelInteretTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelInteretTotal.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelInteretTotall = new PdfPCell(new Phrase( "" +simulation.getInteretTotale() , subFontPara13N));
//                        CelInteretTotall.setPadding(12);
//                        CelInteretTotall.setColspan(2);
//                        CelInteretTotall.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelInteretTotall.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableInteretTotal.addCell(CelInteretTotal);
//                        tableInteretTotal.addCell(CelInteretTotall);
//	                        
//	                        
//                      //fiin P2
//                        Paragraph finPage2= new Paragraph(" Page 2/2" , smallBold);
//                        finPage2.setAlignment(Element.ALIGN_RIGHT);
                        
                        	my_pdf_report.add(imgBank);
                        	my_pdf_report.add(titreBank);
	                        my_pdf_report.add(separator1);
	                        my_pdf_report.add(titre);
	                        my_pdf_report.add(dateStr);
	                        
//	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(espace);
//	                        
	                        my_pdf_report.add(para1);
	                        my_pdf_report.add(para2);
//	                        
//	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(titre2);
	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(table1);
	                        
//	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(separator);

	                        
	                        
//	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(titre1);
	                        my_pdf_report.add(espace);
	                        
	                        my_pdf_report.add(table);   
	                        my_pdf_report.add(separator);
	                        my_pdf_report.add(titre21);
	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(table4);
	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(finPage1);
//	                        
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
////	                        my_pdf_report.add(espace); 
//	                      
//	                        my_pdf_report.add(finPage1);
//
//	                        my_pdf_report.newPage();
//	                        
//	                        my_pdf_report.add(titre21);
//	                        my_pdf_report.add(espace); 
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableLog);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tabletm);//my_pdf_report.add(espace);
////	                        my_pdf_report.add(tableEch);my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableCap);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableMens);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableInteret);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tablePrincper);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableMtRemboursent);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableInteretTotal);//my_pdf_report.add(espace);
//	                        
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(finPage2);
	                        
	                        my_pdf_report.close();
	                        file.close();
	                        
	          Runtime.getRuntime()
	                                .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\HP AYEDI\\Desktop\\PDF\\ESTIMATION_" + idSimulation + "_"+formater.format(d)+".pdf");
	                       // p.waitFor(2, TimeUnit.SECONDS);

						

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} catch (DocumentException e) {
					e.printStackTrace();
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return "ESTIMATION_" + idSimulation + "_"+formater.format(d)+".pdf";
	}

}
