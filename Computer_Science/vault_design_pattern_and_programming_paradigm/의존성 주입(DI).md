메인 모듈이 '직접' 다른 하위 모듈에 대한 의존성을 주기보다는 중간에 의존성 주입자가 이 부분을 가로채 메인 모듈에 '간접'적으로 의존성을 주입하는 방식입니다. 이를 통해 메인 모듈은 하위 모듈에 대한 의존성이 떨어지게 됩니다. 참고로 이를 '디커플링이 된다'고도 합니다.
장점:
모듈들을 쉽게 교체할 수 있는 구조가 되어 테스팅하기 쉽고 마이그레이션하기도 수월합니다. 또한, 구현할 때 추상화 레이어를 넣고 이를 기반으로 구현체를 넣어 주기 때문에 애플리케이션 의존성 방향이 일관되고, 애플리케이션을 쉽게 추론할 수 있으며, 모듈 간의 관계들이 조금 더 명확해집니다.
단점:
모듈들이 더욱더 분리되므로 클래스 수가 늘어나 복잡성이 증가될 수 있으며 약간의 런타임 패널티가 생기기도 합니다.
[[의존성 주입(DI)]]은 [[의존 역전 원칙]]을 지켜주면서 만들어야 합니다.
