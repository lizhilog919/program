package com.test.demo.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MyRender implements GLSurfaceView.Renderer {

    private final String vertexShaderCode =
                    "attribute vec4 vPosition;" +
                    "void main() {" +
                    "  gl_Position = vPosition;" +
                    "  gl_PointSize = 10.0f;" +
                    "}";

    private final String fragmentShaderCode =
                    "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";

    public static int loadShader(int type, String shaderCode){
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

    private int mProgram;

    public static int createProgram(String  vertexShaderCode, String fragmentShaderCode){
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        int program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);
        return program;
    }

    public static FloatBuffer createFloatBuffer(float[] vertexs){
        ByteBuffer bb = ByteBuffer.allocateDirect(vertexs.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(vertexs);
        vertexBuffer.position(0);
        return vertexBuffer;
    }


    float[] vertexs = {
            0.5f, 0.5f, 0.0f,
            0.2f,0.4f,0.0f
    };

    float color[] = {0.0f, 1.0f, 0f, 1.0f};

    FloatBuffer mVertexBuffer;

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);
        mVertexBuffer = createFloatBuffer(vertexs);
        mProgram = createProgram(vertexShaderCode, fragmentShaderCode);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GL10.GL_COLOR_BUFFER_BIT);
        GLES20.glUseProgram(mProgram);
        int mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        GLES20.glEnable(GLES20.GL_ALIASED_POINT_SIZE_RANGE);
        GLES20.glVertexAttribPointer(mPositionHandle, 3, GLES20.GL_FLOAT, false, 3 * 4, mVertexBuffer);
        int mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
        GLES20.glUniform4fv(mColorHandle, 1, color, 0);
        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, vertexs.length / 3);
        GLES20.glDisableVertexAttribArray(mPositionHandle);

    }
}
