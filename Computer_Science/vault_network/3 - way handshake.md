![](https://miro.medium.com/v2/resize:fit:828/0*WcbPv9sWlCl6RV4a)
1. SYN 단계: 클라이언트는 SYN(Synchronize, 동기화) [[TCP 세그먼트|세그먼트]]를 보냅니다. 이 [[TCP 세그먼트|세그먼트]]에는 클라이언트의 시퀀스 넘버인 'n'이 있다. 서버가 이를 받는다.
2. SYN-ACK 단계: 서버는 SYN-ACK(Synchronize- Acknowledgement, 동기화 - 응답) [[TCP 세그먼트|세그먼트]]로 응답한다. 이 [[TCP 세그먼트|세그먼트]]에는 서버의 시퀀스 넘버 'm'과 [[응답 번호]] 'n + 1'을 포함한다. 클라이언트가 이를 받는다.
3. ACK 단계: 클라이언트는 [[응답 번호]] 'm + 1'이 포함된 [[TCP 세그먼트|세그먼트]]를 보낸다. 서버가 이를 받고, 응답할 필요는 없다.