package museum_management_system.Presentation.Controller;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.BigliettoDTO;
import museum_management_system.Application.Service.GestioneBigliettiService;
import museum_management_system.Application.Service.GestioneEventi_MostreService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@WebServlet("/bigliettocontroller")
public class BigliettoController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("ticketId");
        String qrCodeURL = null;
        if (text == null || text.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Il testo per il QR code è mancante.");
            return;
        }

        try {
            // Ottieni il percorso assoluto della directory `qrcode` all'interno di `webapp`
            String webAppPath = getServletContext().getRealPath("/");
            String qrCodeDirPath = webAppPath + "qrcode";

            // Crea la directory `qrcode` se non esiste
            File qrCodeDir = new File(qrCodeDirPath);
            if (!qrCodeDir.exists()) {
                qrCodeDir.mkdirs();
            }

            // Crea un nome univoco per il file del QR code
            String fileName = text + ".png";
            Path filePath = Paths.get(qrCodeDirPath, fileName);

            if(!Files.exists(filePath)) {
                // Genera il QR code
                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 300, 300);

                // Scrivi l'immagine sul file
                MatrixToImageWriter.writeToPath(bitMatrix, "PNG", filePath);
            }


            // Costruisci l'URL per accedere al file
            qrCodeURL = req.getContextPath() + "/qrcode/" + fileName;

            // Rispondi con il QR code
            //resp.setContentType("text/html");
            //resp.getWriter().println("<h1>QR Code Generato</h1>");
            //resp.getWriter().println("<img src='" + qrCodeURL + "' alt='QR Code'>");

        } catch (WriterException e) {
            System.out.println("Impossibile generare il QR code");
        }
        catch (IOException e) {
            System.out.println("Impossibile salvare il QR code");
        }

        //String qrcodePath = "/qrcode/" + 1 + ".png";
        req.setAttribute("titolare", req.getParameter("titolare"));
        req.setAttribute("qrcode", qrCodeURL);
        req.getRequestDispatcher("WEB-INF/pages/ticketRender.jsp").forward(req, resp);
    }
}
