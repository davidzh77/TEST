/**
 * 
 */
package Maven;

import java.io.IOException;   
import java.util.regex.Matcher;

import javax.tools.Tool;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.ToolRunner;
/**
 * @author tprc
 *
 */
public class MaxTemperatureMapper {
	

	  public class AMapper extends Mapper<LongWritable, Text, Text,
	  IntWritable> {
		  
	        public void map(Object key, Text value, Context context) 
	        		throws IOException, InterruptedException {
	        	String line = value.toString();
	            String year = line.substring(15,19);
	            int airTemperature = Integer.parseInt(line.substring(87, 92));
	            context.write(new Text(year), new IntWritable(airTemperature));
	        }
	    }
	  public class AReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		  public void reduce(Text key, Iterable<IntWritable> values, Context context)
				  throws IOException, InterruptedException 
		  {
			  int maxValue = Integer.MIN_VALUE;
			  for (IntWritable value : values) {
				  maxValue = Math.max(maxValue, value.get());
			  }
			  context.write(key, new IntWritable(maxValue));
		  }
	  }
	 public static void Main(String[] args){
		
		 
	 }
}
