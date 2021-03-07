package com.example.lescapteurs;

import android.app.Activity;
import android.graphics.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.camera.core.*;
import androidx.camera.lifecycle.ProcessCameraProvider;

import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.google.common.util.concurrent.ListenableFuture;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;


public class CameraActivity extends Activity implements SurfaceHolder.Callback {
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private Camera mCamera;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        SurfaceView surface = (SurfaceView)findViewById(R.id.surfaceView);
        SurfaceHolder holder = surface.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        // On déclare que la classe actuelle gérera les callbacks
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        holder.addCallback(this);
    }
    // Se déclenche quand la surface est créée
    public void surfaceCreated(SurfaceHolder holder) {
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindPreview(cameraProvider);
            } catch (ExecutionException | InterruptedException e) {
                // No errors need to be handled for this Future.
                // This should never be reached.
            }
        }, ContextCompat.getMainExecutor(this));

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
        Preview preview = new Preview.Builder().build();

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();
        PreviewView previewView = (PreviewView)findViewById(R.id.previewView);
        preview.setSurfaceProvider(previewView.getSurfaceProvider());
        mCamera = (Camera) cameraProvider.bindToLifecycle((LifecycleOwner)this, cameraSelector, preview);
    }

}