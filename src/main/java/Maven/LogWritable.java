/**
 * 
 */
package Maven;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;


public class LogWritable implements Writable {

	private Text userIP, timestamp, request;
	private IntWritable responseSize, status;

	public LogWritable() {
		this.userIP = new Text();
		this.timestamp = new Text();
		this.request = new Text();
		this.responseSize = new IntWritable();
		this.status = new IntWritable();
	}

	public void write(DataOutput out) throws IOException {
		userIP.write(out);
		timestamp.write(out);
		request.write(out);
		responseSize.write(out);
		status.write(out);
	}

	public void readFields(DataInput in) throws IOException {
		userIP.readFields(in);
		timestamp.readFields(in);
		request.readFields(in);
		responseSize.readFields(in);
		status.readFields(in);

	}

	public class LogProcessorMap extends
			Mapper<LongWritable, Text, Text, LogWritable> {

	}

	public class LogProcessorReduce extends
			Reducer<Text, LogWritable, Text, IntWritable> {
		public void reduce(Text key, Iterable<LogWritable> values,
				Context context) {
		}
	}
}
