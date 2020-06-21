#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>

QT_BEGIN_NAMESPACE
namespace Ui { class Widget; }
QT_END_NAMESPACE

class Widget : public QWidget
{
    Q_OBJECT

public:
    Widget(QWidget *parent = nullptr);
    ~Widget();

    void search_dist(QPainter&);
    void createPoint(QPainter&);
    void createLines(QPainter&);
    void paintEvent(QPaintEvent*);
private slots:
    void on_drawLines_clicked();

    void on_findDistance_clicked();

    void on_drawPoint_clicked();

    void on_findCommonPoint_clicked();

private:
    Ui::Widget *ui;
    double line1_x1,
    line1_y1,
    line1_x2,
    line1_y2,
    line2_x1,
    line2_y1,
    line2_x2,
    line2_y2,
    point_x,
    point_y,
    x,
    y,
    findX = 0,
    findY = 0;

};
#endif // WIDGET_H
