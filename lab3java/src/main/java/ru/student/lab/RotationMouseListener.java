package ru.student.lab;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class RotationMouseListener implements MouseListener {

    private final Renderer renderer;

    private float mouseStartX = 0;
    private float mouseStartY = 0;

    private boolean hasRotationStarted = false;

    public RotationMouseListener(Renderer renderer) {
        this.renderer = renderer;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        hasRotationStarted = true;
        mouseStartX = e.getX();
        mouseStartY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        hasRotationStarted = false;
        renderer.xRotationAngle = 0;
        renderer.yRotationAngle = 0;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (hasRotationStarted) {
            renderer.xRotationAngle += (e.getY() - mouseStartY);
            renderer.yRotationAngle += (e.getX() - mouseStartX);
            mouseStartX = e.getX();
            mouseStartY = e.getY();
        }
    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {

    }
}
