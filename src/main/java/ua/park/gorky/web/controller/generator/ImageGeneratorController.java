package ua.park.gorky.web.controller.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.park.gorky.web.constants.WebConsts;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Vladyslav
 */
@Controller
public class ImageGeneratorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageGeneratorController.class);
    private static final String IMAGE_CONTENT = "image/*";

    @RequestMapping(method = RequestMethod.GET, value = WebConsts.Mapping.IMAGE)
    public void generateImage(HttpServletResponse response, @RequestParam String imgPath) throws IOException {
        File image = new File(imgPath);
        try (FileInputStream stream = new FileInputStream(image)) {
            response.setContentType(IMAGE_CONTENT);
            IOUtils.writeStream(stream, response.getOutputStream());
        } catch (IOException ex) {
            LOGGER.error("Image not generated. " + ex);
        }
    }

    private static class IOUtils {
        /**
         * Method rewriting incoming file through the stream.
         *
         * @param inputStream
         *            - stream from which file is reading.
         * @param outputStream
         *            - stream in which file data will be stored.
         * @throws IOException
         */
        public static void writeStream(InputStream inputStream,
                                       OutputStream outputStream) throws IOException {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();

        }
    }
}
