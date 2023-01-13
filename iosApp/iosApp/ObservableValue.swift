//import NexleModule
//
//class ObservableValue<T: AnyObject>: ObservableObject {
//
//    private let observableValue: Value<T>
//    private var observer: ((T)-> Void)?
//
//    @Published var value: T
//
//
//    init(_ value: Value<T>) {
//        self.observableValue = value
//        self.value = self.observableValue.value
//
//        self.observer = {[weak self] value in self?.value = value}
//
//        if let observer = self.observer {
//            self.observableValue
//                .subscribe(observer: observer)
//        }
//    }
//
//    deinit {
//        guard let observer = observer else { return }
//        observableValue.unsubscribe(observer: observer)
//    }
//}
