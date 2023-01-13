import SwiftUI
import NexleModule

struct RootView: View {
    
    private var childStack: Value<ChildStack<AnyObject, RootScenceChild>>
    
    init(_ component: RootScence) {
        self.childStack = component.childStack
    }
    
    var body: some View {
        let child = childStack.value.active.instance
        
        switch child {
        case let splash as RootScenceChild.Splash:
            SplashView(splash.component)
        case let welcome as RootScenceChild.Welcome:
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
