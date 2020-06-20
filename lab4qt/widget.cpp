#include "widget.h"
#include "ui_widget.h"
#include <iostream>

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

void Widget::paintEvent(QPaintEvent *)
{
    QPainter painter(this);
    QPen pen(Qt::black);
    pen.setWidth(2);
    painter.setPen(pen);
    drawFigure(painter);
}

void Widget::drawFigure(QPainter &painter)
{
    count();
    painter.drawLine(points[0], points[1]);
    painter.drawLine(points[0], points[2]);
    painter.drawLine(points[0], points[3]);
    painter.drawLine(points[3], points[1]);
    painter.drawLine(points[2], points[1]);
    painter.drawLine(points[3], points[2]);
}

void Widget::count(){
    int size = ui->sizeSlider->value();
    int move = ui->moveSlider->value();

    points[0] = QPoint((60 + move * 2) * size * 0.05,(130 + move * 2) * size * 0.05);
    points[1] = QPoint((180 + move * 2) * size * 0.05,(130 + move * 2) * size * 0.05);
    points[2] = QPoint((150 + move * 2) * size * 0.05,(220 + move * 2) * size * 0.05);
    points[3] = QPoint((75 + move * 2) * size * 0.05,(20 + move * 2) * size * 0.05);
}

void Widget::on_moveSlider_valueChanged(int value)
{
    this->update();
    std::cout << "move: " << value << std::endl;

}

void Widget::on_sizeSlider_valueChanged(int value)
{
    this->update();
    std::cout << "size: " << value << std::endl;
}
