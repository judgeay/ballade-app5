package org.polytech.project.balladeapp5;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by remipraud on 24/06/13.
 */
public class MeshRender implements Renderer
{
    private Mesh mesh = new Mesh();
    private FloatBuffer vertexBuffer;
    private FloatBuffer colorBuffer;
    private ByteBuffer  indexBuffer;
    private FloatBuffer normalBuffer;
    private float[] mViewMatrix = new float[16];

    private float cameraX = 5.0f;


    float rquad = 0;
    float rtri = 0;

    private float colors[] = {
            0.0f,  1.0f,  0.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            0.0f,  0.0f,  1.0f,  1.0f,
            1.0f,  0.0f,  1.0f,  1.0f
    };

    /**
     * The initial indices definition
     *
     * The indices define our triangles.
     * Always two define one of the six faces
     * a cube has.
     */
    private byte indices[] = {
    					/*
    					 * Example:
    					 * Face made of the vertices lower back left (lbl),
    					 * lfl, lfr, lbl, lfr, lbr
    					 */
            0, 4, 5,    0, 5, 1,
            //and so on...
            1, 5, 6,    1, 6, 2,
            2, 6, 7,    2, 7, 3,
            3, 7, 4,    3, 4, 0,
            4, 7, 6,    4, 6, 5,
            3, 0, 1,    3, 1, 2
    };

    public Mesh getMesh() {
        return mesh;
    }

    public void setMesh(Mesh amesh)
    {
        mesh = amesh;

        //generate buffer
        if (amesh != null)
        {
            ByteBuffer byteBuf = ByteBuffer.allocateDirect(amesh.vertices.size()*4*3); //8 -> sizeof(double)*X,Y,Z
            byteBuf.order(ByteOrder.nativeOrder());
            vertexBuffer = byteBuf.asFloatBuffer();
            vertexBuffer.position(0);

            for(Vector3 vec : amesh.vertices)
            {
                try
                {
                    double[] vec_array  = vec.array();
                    for(int i=0;i<vec_array.length;i++){
                        vertexBuffer.put((float) vec_array[i]);
                    }

                }
                catch(Exception e)
                {
                    Log.e("Display", "Impossible de changer le texte : " + e);
                }
            }
            vertexBuffer.position(0);

            ByteBuffer normBuff = ByteBuffer.allocateDirect(amesh.normals.size()*4*3); //8 -> sizeof(float)*X,Y,Z
            normBuff.order(ByteOrder.nativeOrder());
            normalBuffer = normBuff.asFloatBuffer();
            normalBuffer.position(0);

            for(Vector3 vec : amesh.normals)
            {
                try
                {
                    double[] vec_array  = vec.array();
                    for(int i=0;i<vec_array.length;i++){
                        normalBuffer.put((float) vec_array[i]);
                    }

                }
                catch(Exception e)
                {
                    Log.e("Display", "Impossible de changer le texte : " + e);
                }
            }

            byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
            byteBuf.order(ByteOrder.nativeOrder());
            colorBuffer = byteBuf.asFloatBuffer();
            colorBuffer.put(colors);
            colorBuffer.position(0);

            //
            indexBuffer = ByteBuffer.allocateDirect(indices.length);
            indexBuffer.put(indices);
            indexBuffer.position(0);
        }
        else
        {
            vertexBuffer = null;
            colorBuffer = null;
            indexBuffer = null;
        }
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        //ByteBuffer byteBuf = ByteBuffer.allocateDirect(4);
        //byteBuf.order(ByteOrder.nativeOrder());
        //FloatBuffer lightBuffer = byteBuf.asFloatBuffer();
        //float [] truc = {0.0f, 0.0f, 0.0f, 1.0f};
        //lightBuffer.put(truc);

        gl.glShadeModel(GL10.GL_SMOOTH); 			//Enable Smooth Shading
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f); 	//Black Background
        gl.glClearDepthf(1.0f); 					//Depth Buffer Setup
        gl.glEnable(GL10.GL_DEPTH_TEST); 			//Enables Depth Testing
        gl.glEnable(gl.GL_LIGHTING);
        gl.glEnable(gl.GL_LIGHT0);
        //gl.glLightfv(gl.GL_LIGHT0, gl.GL_AMBIENT, lightBuffer);
        gl.glDepthFunc(GL10.GL_LEQUAL); 			//The Type Of Depth Testing To Do
        //Really Nice Perspective Calculations
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
//        GLU.gluLookAt(gl, 500.0f, 500.0f, 500.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);

    }

    public void onDrawFrame(GL10 gl) {
        //Clear Screen And Depth Buffer
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();					//Reset The Current Modelview Matrix

        //Drawing
//        gl.glTranslatef(0.0f, -1.2f, -7.0f);	//Move down 1.0 Unit And Into The Screen 7.0
        //Minor change: Scale the Cube to 80 percent, otherwise it would be too large for the Emulator screen
//        gl.glScalef(0.8f, 0.8f, 0.8f);

        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);

        // Position the eye behind the origin.
        final float eyeX = 0.0f;
        final float eyeY = 0.0f;
        final float eyeZ = 15.5f;

        // We are looking toward the distance
        final float lookX = 0.0f;
        final float lookY = 0.0f;
        final float lookZ = -20.0f;

        // Set our up vector. This is where our head would be pointing were we holding the camera.
        final float upX = 0.0f;
        final float upY = 1.0f;
        final float upZ = 0.0f;

        // Set the view matrix. This matrix can be said to represent the camera position.
        // NOTE: In OpenGL 1, a ModelView matrix is used, which is a combination of a model and
        // view matrix. In OpenGL 2, we can keep track of these matrices separately if we choose.
        GLU.gluLookAt(gl, eyeX, eyeY, eyeZ, lookX, lookY, lookZ, upX, upY, upZ);

        gl.glRotatef(rquad, 1, 1, 0f);	//Rotate The Square On The X axis

        draw(gl);   							//Draw the shape

        /*
        //Reset The Current Modelview Matrix
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, 1.3f, -6.0f);		//Move up 1.3 Units and -6.0 as the origin matrix is loaded before
        gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);	//Rotate The Triangle On The Y axis
        draw(gl);						        //Draw the shape
        */

        //Rotation
        //cameraX += 100.0f; 							//Increase The Rotation Variable For The Pyramid
        rquad -= 2.0f; 						//Decrease The Rotation Variable For The Cube
    }

    /**
     * If the surface changes, reset the view
     */
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if(height == 0) { 						//Prevent A Divide By Zero By
            height = 1; 						//Making Height Equal One
        }

        gl.glViewport(0, 0, width, height); 	//Reset The Current Viewport
        gl.glMatrixMode(GL10.GL_PROJECTION); 	//Select The Projection Matrix
        gl.glLoadIdentity(); 					//Reset The Projection Matrix

        //Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);

        gl.glMatrixMode(GL10.GL_MODELVIEW); 	//Select The Modelview Matrix
        gl.glLoadIdentity(); 					//Reset The Modelview Matrix
    }

    public MeshRender()
    {
        this.mesh = null;
    }

    public void draw(GL10 gl)
    {
        //Point to our buffers
        gl.glFrontFace(GL10.GL_FRONT);
        gl.glEnable(gl.GL_NORMALIZE);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);

        //Point to our buffers
        gl.glColor4f(1.0f,1.0f,0.0f,1.0f);
        if (vertexBuffer != null)
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        if (normalBuffer != null)
            gl.glNormalPointer(GL10.GL_FLOAT, 6, normalBuffer);

        //Enable the vertex and color state
//        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glDrawArrays(gl.GL_TRIANGLES, 0, vertexBuffer.limit()/3);

        //Draw the vertices as triangles, based on the Index Buffer information
//        gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_BYTE, indexBuffer);

        //Disable the client state before leaving
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
    }
}
