#include "widget.h"
#include "ui_widget.h"

#include <QPainter>

Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
{
    ui->setupUi(this);
    setFixedSize(800, 600);

}

Widget::~Widget()
{
    delete ui;
}

void Widget::paintEvent(QPaintEvent *event)
{
    Q_UNUSED(event);
    QPainter paint(this);
    drawFigure(paint);
}

void Widget::drawFigure(QPainter &painter)
{
    QPen pen(Qt::black);
    pen.setWidth(1);
    painter.setPen(pen);

    int i;
    int width = this->width(), height = this->height();
    double q,w,e,t;
    double r1 = -0.631231, r2= -0.488313;

    for (int x = 0; x <width ; x++) {
        for (int y = 0; y < height; y++) {
            q = 1.5 * (x - width / 2) / (0.5 * width);
            w = (y - height / 2) / (0.5 * height);
            for (i = 0; i < 1000; i++) {
                e = q;
                t = w;

                q = ((e * e) - (t * t)) + r1;
                w = (2 * e * t) + r2;

                if (((q * q) + (w * w)) > 4) break;
            }
            pen.setColor(QColor(255, (i * 9) % 255, 255, (i * 9) % 255));
            painter.setPen(pen);
            painter.drawPoint(QPoint(x, y));
        }
    }

}


