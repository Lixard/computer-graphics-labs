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
    void paintEvent(QPaintEvent *);
    void drawFigure(QPainter &);

    void count();
private slots:

    void on_moveSlider_valueChanged(int value);

    void on_sizeSlider_valueChanged(int value);

private:
    Ui::Widget *ui;
    QPoint points[4];


};
#endif // WIDGET_H
