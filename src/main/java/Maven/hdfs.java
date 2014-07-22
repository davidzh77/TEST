/**
 * 
 */
package Maven;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @author tprc
 *
 */
public class hdfs {
	
	public static void Main(String[] args){
		try {
			
			if (args.length == 2){
				Path inPath = new Path(args[0]);
				Path outPath = new Path(args[1]);
				hdfs showMe = new hdfs();
				showMe.showHDFS(inPath, outPath);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private void showHDFS(Path inPath, Path outPath) throws IOException{
		Configuration config = new Configuration();
		FileSystem hdfs = FileSystem.get(config);
		LocalFileSystem local = FileSystem.getLocal(config);
		
		FSDataInputStream inStream = local.open(inPath);
		FSDataOutputStream outStream = hdfs.create(outPath);
		
		byte[] fromFile =new byte[1000];
		int bytesRead = 0;
		while ( (bytesRead = inStream.read(fromFile) ) >0){
			System.out.println(bytesRead);
		}
		outStream.write(fromFile, 0, bytesRead );
		inStream.close();
		outStream.close();
	}
}
