package org.test.cv;

import org.apache.commons.io.IOUtils;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;

public class AideoTest {

    public static boolean isStart = false;

    public static void main(String[] args) throws Exception {
        isStart = true;
        frameRecord("C:\\Users\\lix\\Videos\\Captures\\test\\test.mp4",
                "C:\\Users\\lix\\Music\\test\\test2.mp3");
    }

    public static void frameRecord(String inputFile, String outputFile)
        throws Exception, org.bytedeco.javacv.FrameRecorder.Exception {
        // 获取视频源
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputFile);
        grabber.setOption("rtsp_transport", "tcp");
        grabber.setVideoCodec(avcodec.AV_CODEC_ID_H264); //avcodec.AV_CODEC_ID_H264  //AV_CODEC_ID_MPEG4

        // 流媒体输出地址，分辨率（长，高），是否录制音频（0:不录制/1:录制）
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputFile, 2);
//        recorder.setSampleRate(grabber.getSampleRate());

//        recorder.setFormat("wav");
//        recorder.setFrameRate(30);
//        recorder.setVideoBitrate(720 * 576);
        //编码格式

//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); //avcodec.AV_CODEC_ID_H264  //AV_CODEC_ID_MPEG4
        recordByFrame(grabber, recorder);
    }

    private static void recordByFrame(FFmpegFrameGrabber grabber, FFmpegFrameRecorder recorder)
            throws Exception {
        try {
            // 建议在线程中使用该方法
            grabber.start();
            grabber.setAudioCodec(avcodec.AV_CODEC_ID_MP3);
            System.out.println(grabber.getAudioCodec());
//            recorder.setAudioCodec(grabber.getAudioCodec());
            System.out.println(recorder.getAudioCodec());

            recorder.setVideoCodec(grabber.getVideoCodec());
            recorder.setImageHeight(grabber.getImageHeight());
            recorder.setImageWidth(grabber.getImageWidth());
            recorder.start();

            recorder.setAudioCodec(grabber.getAudioCodec());
            long t1 = System.currentTimeMillis();

            Frame frame = null;
            // 视频转音频
            while (isStart && (frame = grabber.grabSamples()) != null) {
                long t2 = System.currentTimeMillis();
                if (t2 - t1 > 2 * 60 * 60 * 1000) {
                    break;
                }
                recorder.recordSamples(frame.samples);
            }
            recorder.stop();
            grabber.stop();
        } finally {
            IOUtils.closeQuietly(recorder);
            IOUtils.closeQuietly(grabber);
        }
    }

}
