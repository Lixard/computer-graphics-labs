#include "widget.h"
#include "ui_widget.h"
#include "findcoordpoint.h"
#define eps 0.0001

#include <cmath>
#include <QMessageBox>
#include <QPainter>



double dist_p_p(double ax, double ay, double bx, double by)
{
    return sqrt((bx - ax)*(bx - ax) + (by - ay)*(by - ay));
}

double GetDistanceToSegment(double ax, double ay, double bx, double by, double x, double y)
{
    double a = dist_p_p(x, y, ax, ay);
    double b = dist_p_p(x, y, bx, by);
    double c = dist_p_p(ax, ay, bx, by);
    if (c < eps)
        return 0;
    if (a >= b + c) return b;
    if (b >= a + c) return a;
    double p = (a + b + c) / 2.0;
    double s = sqrt((p - a) * (p - b) * (p - c) * p);
    return s * 2.0 / c;
}

Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
{
    ui->setupUi(this);
    setFixedSize(800,600);
}

Widget::~Widget()
{
    delete ui;
}



void Widget::createLines(QPainter &painter){
    QPen pen(Qt::black);
    pen.setWidth(5);
    QPoint line1_point1(line1_x1,line1_y1);
    QPoint line1_point2(line1_x2,line1_y2);
    QPoint line2_point1(line2_x1,line2_y1);
    QPoint line2_point2(line2_x2,line2_y2);
    painter.setPen(pen);
    painter.drawLine(line1_point1,line1_point2);
    painter.drawLine(line2_point1,line2_point2);
}

void Widget::paintEvent(QPaintEvent *event)
{
    Q_UNUSED(event);
    QPainter painter(this);
    createLines(painter);
    search_dist(painter);
    createPoint(painter);

}

void Widget::createPoint(QPainter &painter){
    QPen pen(Qt::darkBlue);
    pen.setWidth(8);
    QPoint point(point_x,point_y);
    painter.setPen(pen);
    painter.drawPoint(point);
}

void Widget::search_dist(QPainter &painter)
{
    QPen pen(Qt::yellow);
    pen.setWidth(6);
    QPoint point(x,y);
    painter.setPen(pen);
    painter.drawPoint(point);
}

void Widget::on_drawLines_clicked()
{
    line1_x1 = ui->line1_x1->text().toDouble();
    line1_y1 = ui->line1_y1->text().toDouble();
    line1_x2 = ui->line1_x2->text().toDouble();
    line1_y2 = ui->line1_y2->text().toDouble();
    line2_x1 = ui->line2_x1->text().toDouble();
    line2_y1 = ui->line2_y1->text().toDouble();
    line2_x2 = ui->line2_x2->text().toDouble();
    line2_y2 = ui->line2_y2->text().toDouble();
    update();
}

void Widget::on_findDistance_clicked()
{
    QMessageBox message;
    double dist1 = GetDistanceToSegment(line1_x1,line1_y1,line1_x2,line1_y2,point_x,point_y);
    double dist2 = GetDistanceToSegment(line2_x1,line2_y1,line2_x2,line2_y2,point_x,point_y);

    if(dist1>dist2)
    {
        QString str = "Расстояние от точки до первого отрезка: " + QString::number(dist2);
        message.setText(str);
        message.exec();
    }
    else
    {
        QString str = "Расстояние от точки до второго отрезка: " + QString::number(dist1);
        message.setText(str);
        message.exec();
    }
}

void Widget::on_drawPoint_clicked()
{
    point_x = ui->point_x->text().toDouble();
    point_y = ui->point_y->text().toDouble();
    update();
}

void Widget::on_findCommonPoint_clicked()
{
    FindCoordPoint findCoordPoint;
    findCoordPoint.addListPoint(line1_x1,line1_y1);
    findCoordPoint.addListPoint(line1_x2,line1_y2);
    findCoordPoint.addListPoint(line2_x1,line2_y1);
    findCoordPoint.addListPoint(line2_x2,line2_y2);
    if (findCoordPoint.setDataLine())
    {
        findCoordPoint.getXYCoord(findX,findY);
        x = findX;
        y = findY;
        ui->commonPoint_x->setText(QLocale ().toString(findX));
        ui->commonPoint_y->setText(QLocale ().toString(findY));
        update();
    }
}
