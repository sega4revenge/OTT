import SwiftUI
import NexleModule

struct RootView: View {
    
    private var childStack: Value<ChildStack<AnyObject, TodoRootChild>>
    
    init(_ component: TodoRoot) {
        self.childStack = component.childStack
    }
    
    var body: some View {
        let child = childStack.value.active.instance
        
        switch child {
        case let splash as TodoRootChild.Main:
            SplashView(splash.component)
        case let welcome as TodoRootChild.Welcome:
            WelcomeView(welcome.component)
        default:
            EmptyView()
        }
    }
    
}
//
//struct RootView_Previews: PreviewProvider {
//    static var previews: some View {
//        RootView()
//    }
//}
