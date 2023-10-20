![](https://media.geeksforgeeks.org/wp-content/uploads/20220406111342/TheFourWayHandshakeProcess.jpg)
1. 클라이언트가 서버에 FIN flag가 설정된 [[TCP 세그먼트|세그먼트]]를 보냅니다.
2. 서버가 클라이언트에 ACK flag가 설정된 [[TCP 세그먼트|세그먼트]]를 보냅니다.
3. 서버가 클라이언트에 FIN flag가 설정된 [[TCP 세그먼트|세그먼트]]를 보냅니다.
4. 클라이언트가 서버에 ACK flag가 설정된 [[TCP 세그먼트|세그먼트]]를 보냅니다. 이 때 클라이언트는 바로 CLOSED 상태가 되지 않고 TIME_WAIT 상태가 된다. 이는 지연 패킷 등으로 인해 잠시 기다린 후 CLOSED 상태가 된다. OS마다 지연 시간은 다르며, 윈도우는 4분으로 설정되어 있다.