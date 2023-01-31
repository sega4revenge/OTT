import SwiftUI
import NexleModule

struct SplashView: View {
    
    private let component: TodoMain
    
    init(_ component: TodoMain) {
        self.component = component
    }
    
    var body: some View {
        VStack {
            Image(ImageAssets.Splash.logo)
            Button("HELLO", action: {
                self.component.onItemClicked(id: 4546)
            })
        }
    }
}
