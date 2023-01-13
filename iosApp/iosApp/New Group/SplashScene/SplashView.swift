import SwiftUI
import NexleModule

struct SplashView: View {
    
    private let component: SplashScene
    
    init(_ component: SplashScene) {
        self.component = component
    }
    
    var body: some View {
        VStack {
            Image(ImageAssets.Splash.logo)
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 2, execute: {
                self.component.onFinishPreparing()
            })
        }
    }
}
