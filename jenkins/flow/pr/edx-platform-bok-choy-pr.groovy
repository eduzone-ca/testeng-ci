import hudson.FilePath
import hudson.model.*

def toolbox = extension."build-flow-toolbox"
def sha1 = build.environment.get("ghprbActualCommit")

guard{
  parallel(
    {
      bok_choy_1 = build('edx-platform-test-subset', sha1: sha1, SHARD: "1", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_1)
    },
    {
      bok_choy_2 = build('edx-platform-test-subset', sha1: sha1, SHARD: "2", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_2)
    },
    {
      bok_choy_3 = build('edx-platform-test-subset', sha1: sha1, SHARD: "3", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_3)
    },
    {
      bok_choy_4 = build('edx-platform-test-subset', sha1: sha1, SHARD: "4", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_4)
    },
    {
      bok_choy_5 = build('edx-platform-test-subset', sha1: sha1, SHARD: "5", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_5)
    },
    {
      bok_choy_6 = build('edx-platform-test-subset', sha1: sha1, SHARD: "6", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_6)
    },
    {
      bok_choy_7 = build('edx-platform-test-subset', sha1: sha1, SHARD: "7", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_7)
    },
    {
      bok_choy_8 = build('edx-platform-test-subset', sha1: sha1, SHARD: "8", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_8)
    },
    {
      bok_choy_9 = build('edx-platform-test-subset', sha1: sha1, SHARD: "9", TEST_SUITE: "bok-choy", PARENT_BUILD: "PR Build #" + build.number)
      toolbox.slurpArtifacts(bok_choy_9)
    },
  )
}rescue{
  FilePath artifactsDir =  new FilePath(build.artifactManager.getArtifactsDir())
  FilePath copyToDir = new FilePath(build.workspace, "edx-platform")
  artifactsDir.copyRecursiveTo(copyToDir)
}
