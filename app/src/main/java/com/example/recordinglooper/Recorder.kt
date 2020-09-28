package com.example.recordinglooper

import android.media.MediaRecorder
import android.provider.MediaStore
import android.util.Log
import java.io.IOException

class Recorder(val outputFileName: String) {
    private val mediaRecorder: MediaRecorder

    init {
        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS)
            setOutputFile(outputFileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            try {
                prepare()
            } catch (e: IOException) {
                Log.e("RECORDER_INIT", "Failed to prepare")
            }
        }

    }

    fun start() {
        mediaRecorder.start()
    }

    fun stop() {
        mediaRecorder.apply {
            stop()
            release()
        }
    }
}