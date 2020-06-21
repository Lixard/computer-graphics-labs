#ifndef FINDCOORDPOINT_H
#define FINDCOORDPOINT_H
#include <list>

class FindCoordPoint
{
public:
    FindCoordPoint();
    struct somePoint
    {
        double x, y;
    };

    struct paramLine
    {
        double a, b, c;
    };
    paramLine myData[2];

    std::list <somePoint> myPoint;
    bool addListPoint(double x, double y);
    bool setDataLine();
    void getXYCoord(double& x1, double& y1);
};

#endif // FINDCOORDPOINT_H
