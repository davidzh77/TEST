/**
 * 
 */
package Maven;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

/**
 * @author tprc
 *
 */
public class FileSystemCat {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		String uri = args[0];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(java.net.URI.create(uri), conf);
		FSDataInputStream in = null;
		try {
		in = fs.open(new Path(uri));
		IOUtils.copyBytes(in, System.out, 4096, false);
		in.seek(0); // go back to the start of the file
		IOUtils.copyBytes(in, System.out, 4096, false);
		} finally {
		IOUtils.closeStream(in);
		}
	}

}
