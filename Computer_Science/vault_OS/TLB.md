TLB는 "Translation Lookaside Buffer"의 약자입니다. TLB는 Memory Management Unit (MMU) 내부에 있는 작고 빠른 캐시로, 가장 최근에 사용된 가상 주소와 해당 가상 주소의 물리 주소 매핑을 저장합니다. TLB는 가상 메모리 시스템에서 주소 변환의 성능을 향상시키기 위해 사용됩니다.

가상 주소를 물리 주소로 변환할 때, 전체 페이지 테이블을 검색하는 것은 시간이 많이 걸립니다. 그러나 TLB는 최근의 주소 변환을 빠르게 캐시하므로, MMU는 많은 경우에 페이지 테이블 전체를 검색할 필요 없이 TLB에서 빠르게 주소 매핑 정보를 찾을 수 있습니다.