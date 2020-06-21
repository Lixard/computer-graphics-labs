#include "findcoordpoint.h"

FindCoordPoint::FindCoordPoint()
{

}

bool FindCoordPoint::addListPoint(double x, double y)
{
    if ((myPoint.size() > 4)) return false;
    somePoint temp;
    temp.x = x;
    temp.y = y;
    myPoint.push_back(temp);
    return true;
}

bool FindCoordPoint::setDataLine()
{
    somePoint tempPoint1, tempPoint2;
    std::list <somePoint>::iterator it = myPoint.begin();
    tempPoint1 = *it;
    it++;
    tempPoint2 = *it;
    myData[0].a = tempPoint2.y - tempPoint1.y;
    myData[0].b = tempPoint1.x - tempPoint2.x;
    myData[0].c = tempPoint1.x * (tempPoint1.y - tempPoint2.y) +
        tempPoint1.y * (tempPoint2.x - tempPoint1.x);
    it++;
    tempPoint1 = *it;
    it++;
    tempPoint2 = *it;
    myData[1].a = tempPoint2.y - tempPoint1.y;
    myData[1].b = tempPoint1.x - tempPoint2.x;
    myData[1].c = tempPoint1.x * (tempPoint1.y - tempPoint2.y) +
        tempPoint1.y * (tempPoint2.x - tempPoint1.x);
    return true;
}

void FindCoordPoint::getXYCoord(double& x1, double& y1)
{
    double D = myData[0].a * myData[1].b - myData[1].a * myData[0].b;
    double Dx = -myData[0].c * myData[1].b + myData[1].c * myData[0].b;
    double Dy = -myData[0].a * myData[1].c + myData[1].a * myData[0].c;
    x1 = Dx / D;
    y1 = Dy / D;
}
