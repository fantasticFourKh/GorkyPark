package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImageGeneretorCommand extends Command {

	private static final long serialVersionUID = -2785976616686657267L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageGeneretorCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String imagePath = request.getParameter("imgpath");
		File image = new File(imagePath);
		FileInputStream stream = new FileInputStream(image);
		try {
			response.setContentType("image/*");
			IOUtils.writeStream(stream, response.getOutputStream());
		} catch (IOException ex) {
			LOGGER.error("Some error" + ex);
		} finally {
			stream.close();
		}
		
		return null;
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
